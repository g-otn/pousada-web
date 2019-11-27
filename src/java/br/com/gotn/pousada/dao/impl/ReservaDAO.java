package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO extends AbstractDAO {
    
    public ReservaDAO() {
        super("reservas", "id");
    }
    
    public ReservaDAO(Connection conexao) {
        super(conexao, "reservas", "id");
    }

    public ReservaDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }

    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#salvar " + entidade.toString());
        return -2L;
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#alterar " + entidade.toString());
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#consultar " + entidade.toString());
        return new ArrayList<>();
    }
    
}
