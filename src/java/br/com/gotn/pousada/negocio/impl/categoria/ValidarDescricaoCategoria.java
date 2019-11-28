package br.com.gotn.pousada.negocio.impl.categoria;

import br.com.gotn.pousada.dao.impl.CategoriaDAO;
import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDescricaoCategoria implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosCategoria#processar");
        Categoria categoria = (Categoria) entidade;
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        StringBuilder sb = new StringBuilder();
        
        if (categoria.getDescricao() == null || categoria.getDescricao().trim().isEmpty()) {
            sb.append("descricao: A descrição é obrigatória\n");
        } else if (categoriaDAO.consultar(entidade).size() > 0) {
            sb.append("descricao: Já existe uma categoria com essa descrição\n");
        }
        
        return sb.toString();
    }
    
}
