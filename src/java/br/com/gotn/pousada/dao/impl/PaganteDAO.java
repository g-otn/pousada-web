package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.Cartao;
import br.com.gotn.pousada.dominio.Endereco;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Pagante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaganteDAO extends AbstractDAO {
    
    public PaganteDAO() {
        super("pagantes", "id");
    }

    public PaganteDAO(Connection conexao) {
        super(conexao, "pagantes", "id");
    }

    public PaganteDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }
    

    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> PaganteDAO#salvar " + entidade.toString());
        Pagante pagante = (Pagante) entidade;
        abrirConexao();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        CartaoDAO cartaoDAO = new CartaoDAO();

        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO " + tabela
                + " (nome, rg, cpf, email, telefone, endereco_id, cartao_id)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, pagante.getNome());
            ps.setString(2, pagante.getRg());
            ps.setString(3, pagante.getCpf());
            ps.setString(4, pagante.getEmail());
            ps.setString(5, pagante.getTelefone());
            ps.setLong(6, pagante.getEndereco().getId());
            ps.setLong(7, pagante.getCartao().getId());
            
            System.out.println(ps);
            ps.executeUpdate(ps.toString(), Statement.RETURN_GENERATED_KEYS);
            
            // Retorna o ID para ser utilizado em chaves estrangeiras ao salvar em outros DAOs
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return -1L;
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> PaganteDAO#alterar " + entidade.toString());
        Pagante pagante = (Pagante) entidade;
        abrirConexao();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        CartaoDAO cartaoDAO = new CartaoDAO();
        
        try {
            enderecoDAO.alterar(pagante.getEndereco());
            cartaoDAO.alterar(pagante.getCartao());
            
            PreparedStatement ps = conexao.prepareStatement("UPDATE " + tabela + " SET "
                + "numero = ?, "
                + "rg = ?, "
                + "cpf = ?, "
                + "email = ?, "
                + "telefone = ? "
                + "WHERE " + colunaId + " = ?"
            );
            ps.setString(1, pagante.getNome());
            ps.setString(2, pagante.getRg());
            ps.setString(3, pagante.getCpf());
            ps.setString(4, pagante.getEmail());
            ps.setString(5, pagante.getTelefone());
            
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        System.out.println("--> PaganteDAO#consultar " + entidade.toString());
        Pagante pagante = (Pagante) entidade;
        abrirConexao();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        CartaoDAO cartaoDAO = new CartaoDAO();
        
        List<EntidadeDominio> pagantesConsultados = new ArrayList<>();

        try {
            PreparedStatement ps;
            
            if (pagante.getId() != -1L) { // id -> consulta de pagante único
                ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id = ? ");
                ps.setLong(1, pagante.getId());
            } else { // nada -> listagem
                ps = conexao.prepareStatement("SELECT * FROM " + tabela);
            }
            
            System.out.println(ps);
            ResultSet rs = conexao.createStatement().executeQuery(ps.toString());
            
            while (rs.next()) {
                Pagante paganteConsultado = 
                        new Pagante(
                                rs.getString("nome"), 
                                rs.getString("rg"), 
                                rs.getString("cpf"), 
                                rs.getString("email"), 
                                rs.getString("telefone"),
                                (Endereco) enderecoDAO.consultar(new Endereco(rs.getLong("endereco_id"))).get(0),
                                (Cartao) cartaoDAO.consultar(new Cartao(rs.getLong("cartao_id"))).get(0)
                        );
                paganteConsultado.getEndereco().setId(rs.getLong("endereco_id"));
                paganteConsultado.getCartao().setId(rs.getLong("cartao_id"));
                paganteConsultado.setId(rs.getLong(colunaId));
                
                pagantesConsultados.add(paganteConsultado);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        System.out.println("A consulta retornou " + pagantesConsultados.size() + " resultado(s)" + (pagantesConsultados.size() == 1 ? ": " + pagantesConsultados.get(0).toString() : ""));
        return pagantesConsultados;
    }
    
}
