package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.util.List;

public class CategoriaDAO implements IDAO {

    @Override
    public void salvar(EntidadeDominio entidade) {
        System.out.println("--> CategoriaDAO#salvar");
        Categoria categoria = (Categoria) entidade;
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> CategoriaDAO#alterar");
    }

    @Override
    public void excluir(EntidadeDominio entidade) {
        System.out.println("--> CategoriaDAO#excluir");
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        System.out.println("--> CategoriaDAO#consultar");
    }
    
}
