package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.Cidade;
import br.com.gotn.pousada.dominio.Endereco;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO extends AbstractDAO {
    
    public EnderecoDAO() {
        super("enderecos", "id");
    }
    
    public EnderecoDAO(Connection conexao) {
        super(conexao, "enderecos", "id");
    }

    public EnderecoDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }

    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> EnderecoDAO#salvar " + entidade.toString());
        Endereco endereco = (Endereco) entidade;
        abrirConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO " + tabela
                + " (estado, cidade, bairro, logradouro, numero)"
                + " VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, endereco.getCidade().getEstado().getDescricao());
            ps.setString(2, endereco.getCidade().getDescricao());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getLogradouro());
            ps.setString(5, endereco.getNumero());
            
            System.out.println(ps);
            ps.executeUpdate();
            
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
        System.out.println("--> EnderecoDAO#alterar " + entidade.toString());
        Endereco endereco = (Endereco) entidade;
        abrirConexao();
        
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE " + tabela + " SET "
                + "estado = ?, "
                + "cidade = ?, "
                + "bairro = ?, "
                + "logradouro = ?, "
                + "numero = ? "
                + " WHERE " + colunaId + " = ?"
            );
            ps.setString(1, endereco.getCidade().getEstado().getDescricao());
            ps.setString(2, endereco.getCidade().getDescricao());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getLogradouro());
            ps.setString(5, endereco.getNumero());
            
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
        System.out.println("--> EnderecoDAO#consultar " + entidade.toString());
        Endereco endereco = (Endereco) entidade;
        abrirConexao();
        
        List<EntidadeDominio> enderecosConsultados = new ArrayList<>();

        try {
            PreparedStatement ps;
            
            if (endereco.getId() != -1L) { // id -> consulta de cartao único
                ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id = ? ");
                ps.setLong(1, endereco.getId());
            } else { // nada -> listagem
                ps = conexao.prepareStatement("SELECT * FROM " + tabela);
            }
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Endereco enderecoConsultado = new Endereco(
                        rs.getString("bairro"), 
                        rs.getString("logradouro"), 
                        rs.getString("numero"), 
                        rs.getString("complemento"), 
                        rs.getString("cep"), 
                        new Cidade(
                                rs.getString("cidade"), 
                                new Estado(
                                        rs.getString("estado")
                                )
                        )
                );
                enderecoConsultado.setId(rs.getLong(colunaId));
                
                enderecosConsultados.add(enderecoConsultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        System.out.println("A consulta retornou " + enderecosConsultados.size() + " resultado(s)" + (enderecosConsultados.size() == 1 ? ": " + enderecosConsultados.get(0).toString() : ""));
        return enderecosConsultados;
    }
    
}
