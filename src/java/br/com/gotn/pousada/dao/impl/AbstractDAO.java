package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.util.ConexaoPostgresSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDAO implements IDAO {

    protected Connection conexao;
    protected String tabela;
    protected String colunaId;

    // Utilizado pelos DAOs quando o mesmo é instânciado com o construtor sem parâmetros (direto da Fachada/Strategy)
    public AbstractDAO(String tabela, String colunaId) {
        this.tabela = tabela;
        this.colunaId = colunaId;
    }

    // Recebe uma conexão já aberta, para quando um DAO chamar o outro
    public AbstractDAO(Connection conexao, String tabela, String colunaId) {
        this.conexao = conexao;
        this.tabela = tabela;
        this.colunaId = colunaId;
    }

    // Abre a conexão do DAO se já não estiver aberta
    protected void abrirConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = ConexaoPostgresSQL.getConexao();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Como o AbstractDAO já possuí os nomes da tabela e da coluna do id e o id da entidade, não é preciso implementar nos outros DAOs a operação de excluir
    @Override
    public void excluir(EntidadeDominio entidade) {
        System.out.println("--> AbstractDAO#excluir " + entidade.toString());
        abrirConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM " + tabela + " WHERE " + colunaId + " = ?");
            ps.setLong(1, entidade.getId());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

}
