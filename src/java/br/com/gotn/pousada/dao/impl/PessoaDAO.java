package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.util.List;

public class PessoaDAO extends AbstractDAO {

    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        System.out.println("--> PessoaDAO#salvar");
    }

    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        System.out.println("--> PessoaDAO#alterar");
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        System.out.println("--> PessoaDAO#consultar");
    }
    
}
