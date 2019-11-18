package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.util.List;

public class PaganteDAO implements IDAO {

    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        System.out.println("--> PaganteDAO#salvar");
    }

    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        System.out.println("--> PaganteDAO#alterar");
    }

    @Override
    public void excluir(EntidadeDominio entidadeDominio) {
        System.out.println("--> PaganteDAO#excluir");
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        System.out.println("--> PaganteDAO#consultar");
    }
    
}
