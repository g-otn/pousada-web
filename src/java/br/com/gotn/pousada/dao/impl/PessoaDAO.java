package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends AbstractDAO {
    
    public PessoaDAO() {
        super("pessoas", "id");
    }
    
    public PessoaDAO(Connection conexao) {
        super(conexao, "pessoas", "id");
    }

    public PessoaDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }

    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> PessoaDAO#salvar " + entidade.toString());
        return -2L;
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> PessoaDAO#alterar " + entidade.toString());
    }

    @Override
    public void excluir(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#excluir " + entidade.toString());
        // EXCLuir asssociação
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        System.out.println("--> PessoaDAO#consultar " + entidade.toString());
        return new ArrayList<>();
    }
    
}
