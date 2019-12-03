package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.QuartoECategorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuartosECategoriasDAO extends AbstractDAO {
    
    public QuartosECategoriasDAO() {
        super(null, null);
    }

    public QuartosECategoriasDAO(Connection conexao) {
        super(conexao, null, null);
    }

    public QuartosECategoriasDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }
    
    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> QuartosECategoriasDAO#salvar " + entidade.toString());
        QuartoECategorias quartoECategorias = (QuartoECategorias) entidade;
        abrirConexao();
        
        QuartoDAO quartoDAO = new QuartoDAO(conexao);
        
        long novoId = quartoDAO.salvar(quartoECategorias.getQuarto());
        
        fecharConexao();
        
        return novoId;
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> QuartosECategoriasDAO#alterar " + entidade.toString());
        QuartoECategorias quartoECategorias = (QuartoECategorias) entidade;
        abrirConexao();
        
        QuartoDAO quartoDAO = new QuartoDAO(conexao);
        
        quartoDAO.alterar(quartoECategorias.getQuarto());
        
        fecharConexao();
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        System.out.println("--> QuartosECategoriasDAO#consultar " + entidade.toString());
        QuartoECategorias quartoECategorias = (QuartoECategorias) entidade;
        abrirConexao();
        
        QuartoDAO quartoDAO = new QuartoDAO(conexao);
        CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
        
        List<EntidadeDominio> quartoECategoriasConsultados = new ArrayList<>();
        
        QuartoECategorias quartoECategoriasConsultado = new QuartoECategorias(-1L);
        quartoECategoriasConsultado.setQuarto((Quarto) quartoDAO.consultar(quartoECategorias.getQuarto()).get(0));
        
        List<Categoria> categorias = new ArrayList<Categoria>();
        for (EntidadeDominio categoria : categoriaDAO.consultar(quartoECategorias.getCategorias().get(0))) {
            categorias.add((Categoria) categoria);
        }
        quartoECategoriasConsultado.setCategorias(categorias);
        
        quartoECategoriasConsultados.add(quartoECategoriasConsultado);
        
        System.out.println("A consulta retornou " + quartoECategoriasConsultados.size() + " resultado(s)" + (quartoECategoriasConsultados.size() == 1 ? ": " + quartoECategoriasConsultados.get(0).toString() : ""));
        
        fecharConexao();
        
        return quartoECategoriasConsultados;
    }
    
}
