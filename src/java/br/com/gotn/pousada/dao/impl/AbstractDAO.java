package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.util.List;

public abstract class AbstractDAO implements IDAO {

    @Override
    public void excluir(EntidadeDominio entidadeDominio) {
        System.out.println("AbstractDAO#excluir");
    }
    
}
