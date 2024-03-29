package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO extends AbstractDAO {
    
    public QuartoDAO() {
        super("quartos", "id");
    }

    public QuartoDAO(Connection conexao) {
        super(conexao, "quartos", "id");
    }

    public QuartoDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }
    
    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> QuartoDAO#salvar " + entidade.toString());
        Quarto quarto = (Quarto) entidade;
        abrirConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO " + tabela
                + " (numero, categoria_id)"
                + " VALUES (?, ?)"
            );
            ps.setString(1, quarto.getNumero());
            ps.setLong(2, quarto.getCategoria().getId());
            
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
        System.out.println("--> QuartoDAO#alterar " + entidade.toString());
        Quarto quarto = (Quarto) entidade;
        abrirConexao();
        
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE " + tabela + " SET "
                + "numero = ?, "
                + "categoria_id = ? "
                + "WHERE " + colunaId + " = ?"
            );
            ps.setString(1, quarto.getNumero());
            ps.setLong(2, quarto.getCategoria().getId());
            ps.setLong(3, quarto.getId());
            
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
        System.out.println("--> QuartoDAO#consultar " + entidade.toString());
        Quarto quarto = (Quarto) entidade;
        abrirConexao();
        CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
        
        List<EntidadeDominio> quartosConsultados = new ArrayList<>();

        try {
            PreparedStatement ps;
            
            if (quarto.getNumero() != null) {
                if (quarto.getId() != -1L) { // descricao e id -> verificação de número já existente fora o próprio cadastro
                    ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id <> ? AND numero = ?");
                    ps.setLong(1, quarto.getId());
                    ps.setString(2, quarto.getNumero());
                } else { // descricao -> verificação de número já existente
                    ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE descricao = ?");
                    ps.setString(1, quarto.getNumero());
                }
            } else if (quarto.getId() != -1L) { // id -> consulta de quarto único
                ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id = ? ");
                ps.setLong(1, quarto.getId());
            } else { // nada -> listagem
                ps = conexao.prepareStatement("SELECT * FROM " + tabela);
            }
            
            System.out.println(ps);
            ResultSet rs = conexao.createStatement().executeQuery(ps.toString());
            
            while (rs.next()) {
                Quarto quartoConsultado = new Quarto(
                        rs.getString("numero"),
                        (Categoria) categoriaDAO.consultar(new Categoria(rs.getLong("categoria_id"))).get(0)
                );
                quartoConsultado.getCategoria().setId(rs.getLong("categoria_id"));
                quartoConsultado.setId(rs.getLong(colunaId));
                
                quartosConsultados.add(quartoConsultado);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        System.out.println("A consulta retornou " + quartosConsultados.size() + " resultado(s)" + (quartosConsultados.size() == 1 ? ": " + quartosConsultados.get(0).toString() : ""));
        return quartosConsultados;
    }
    
}
