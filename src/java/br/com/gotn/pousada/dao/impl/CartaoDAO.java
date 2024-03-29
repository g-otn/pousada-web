package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.Cartao;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CartaoDAO extends AbstractDAO {
    
    public CartaoDAO() {
        super("cartoes", "id");
    }
    
    public CartaoDAO(Connection conexao) {
        super(conexao, "cartoes", "id");
    }

    public CartaoDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }

    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> CartaoDAO#salvar " + entidade.toString());
        Cartao cartao = (Cartao) entidade;
        abrirConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO " + tabela
                + " (numero, data_emissao, data_validade, codigo_seguranca)"
                + " VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, cartao.getNumero());
            ps.setString(2, cartao.getDataEmissao().format(DateTimeFormatter.ofPattern("yy/MM")));
            ps.setString(3, cartao.getDataValidade().format(DateTimeFormatter.ofPattern("yy/MM")));
            ps.setString(4, cartao.getCodigoSeguranca());
            
            System.out.println(ps);
            Statement st = conexao.createStatement();
            st.executeUpdate(ps.toString(), Statement.RETURN_GENERATED_KEYS);
            
            // Retorna o ID para ser utilizado em chaves estrangeiras ao salvar em outros DAOs
            ResultSet rs = st.getGeneratedKeys();
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
        System.out.println("--> CartaoDAO#alterar " + entidade.toString());
        Cartao cartao = (Cartao) entidade;
        abrirConexao();
        
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE " + tabela + " SET "
                + "numero = ?, "
                + "data_emissao = ?, "
                + "data_validade = ?, "
                + "codigo_seguranca = ? "
                + " WHERE " + colunaId + " = ?"
            );
            ps.setString(1, cartao.getNumero());
            ps.setString(2, cartao.getDataEmissao().format(DateTimeFormatter.ofPattern("yy/MM")));
            ps.setString(3, cartao.getDataValidade().format(DateTimeFormatter.ofPattern("yy/MM")));
            ps.setString(4, cartao.getCodigoSeguranca());
            
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
        System.out.println("--> CartaoDAO#consultar " + entidade.toString());
        Cartao cartao = (Cartao) entidade;
        abrirConexao();
        
        List<EntidadeDominio> cartoesConsultados = new ArrayList<>();

        try {
            PreparedStatement ps;
            
            if (cartao.getId() != -1L) { // id -> consulta de cartao único
                ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id = ? ");
                ps.setLong(1, cartao.getId());
            } else { // nada -> listagem
                ps = conexao.prepareStatement("SELECT * FROM " + tabela);
            }
            
            System.out.println(ps);
            ResultSet rs = conexao.createStatement().executeQuery(ps.toString());
            
            while (rs.next()) {
                Cartao cartaoConsultado = new Cartao(
                        rs.getString("numero"),
                        YearMonth.parse(rs.getString("data_emissao"), DateTimeFormatter.ofPattern("MM/yy")),
                        YearMonth.parse(rs.getString("data_validade"), DateTimeFormatter.ofPattern("MM/yy")),
                        rs.getString("codigo_seguranca")
                );
                cartaoConsultado.setId(rs.getLong(colunaId));
                
                cartoesConsultados.add(cartaoConsultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        System.out.println("A consulta retornou " + cartoesConsultados.size() + " resultado(s)" + (cartoesConsultados.size() == 1 ? ": " + cartoesConsultados.get(0).toString() : ""));
        return cartoesConsultados;
    }
    
}
