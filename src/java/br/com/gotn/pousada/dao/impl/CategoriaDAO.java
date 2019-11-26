package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO extends AbstractDAO {

    public CategoriaDAO() {
        super("categorias", "id");
    }
    
    public CategoriaDAO(Connection conexao) {
        super(conexao, "categorias", "id");
    }

    public CategoriaDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }

    @Override
    public void salvar(EntidadeDominio entidade) {
        System.out.println("--> CategoriaDAO#salvar " + entidade.toString());
        Categoria categoria = (Categoria) entidade;
        abrirConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO " + tabela
                + " (descricao, capacidade, preco_diaria)"
                + " VALUES (?, ?, ?)"
            );
            ps.setString(1, categoria.getDescricao());
            ps.setInt(2, categoria.getCapacidade());
            ps.setDouble(3, categoria.getPrecoDiaria());
            
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> CategoriaDAO#alterar " + entidade.toString());
        Categoria categoria = (Categoria) entidade;
        abrirConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE " + tabela + " SET "
                + "descricao = ?,"
                + "capacidade = ?,"
                + "preco_diaria = ?"
                + " WHERE " + colunaId + " = ?"
            );
            ps.setString(1, categoria.getDescricao());
            ps.setInt(2, categoria.getCapacidade());
            ps.setDouble(3, categoria.getPrecoDiaria());
            ps.setLong(4, categoria.getId());
            
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
        System.out.println("--> CategoriaDAO#consultar " + entidade.toString());
        Categoria categoria = (Categoria) entidade;
        abrirConexao();
        
        List<EntidadeDominio> categoriasConsultadas = new ArrayList<>();
        
        try {
            PreparedStatement ps;
            
            if (categoria.getDescricao() != null) {
                if (categoria.getId() != 0L) { // descricao e id -> verificação de descrição já existente fora o próprio cadastro
                    ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id <> ? AND descricao = ?");
                    ps.setLong(1, categoria.getId());
                    ps.setString(2, categoria.getDescricao());
                } else {  // descrição -> verificação de descrição já existente
                    ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE descricao = ?");
                    ps.setString(1, categoria.getDescricao());
                }
            } else if (categoria.getId() != 0L) { // id -> consulta de categoria única
                ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id = ? ");
                ps.setLong(1, categoria.getId());
            } else { // nada -> listagem
                ps = conexao.prepareStatement("SELECT * FROM " + tabela);
            }
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Categoria categoriaConsultada = new Categoria(rs.getString("descricao"), rs.getDouble("preco_diaria"), rs.getInt("capacidade"));
                categoriaConsultada.setId(rs.getLong(colunaId));
                categoriasConsultadas.add(categoriaConsultada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        System.out.println("A consulta retornou " + categoriasConsultadas.size() + " resultado(s)" + (categoriasConsultadas.size() == 1 ? ": " + categoriasConsultadas.get(0).toString() : ""));
        return categoriasConsultadas;
    }

}
