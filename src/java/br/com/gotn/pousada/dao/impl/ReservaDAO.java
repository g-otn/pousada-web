package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.util.List;

public class ReservaDAO implements IDAO {

    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        System.out.println("--> ReservaDAO#salvar");
    }

    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        System.out.println("--> ReservaDAO#alterar");
    }

    @Override
    public void excluir(EntidadeDominio entidadeDominio) {
        System.out.println("--> ReservaDAO#excluir");
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        System.out.println("--> ReservaDAO#consultar");
    }
    
}
