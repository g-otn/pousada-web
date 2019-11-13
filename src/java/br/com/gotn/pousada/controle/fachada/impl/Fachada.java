package br.com.gotn.pousada.controle.fachada.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;
import br.com.gotn.pousada.controle.fachada.IFachada;
import java.util.List;
import java.util.Map;

public class Fachada implements IFachada {
    
    private Map<String, Map<String, List<IStrategy>>> regrasNegocio;
    private StringBuilder sb = new StringBuilder();
    private Resultado resultado;

    public Fachada() {

    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#salvar");
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#alterar");
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        System.out.println("--> Fachada#excluir");
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#consultar");
    }

    private void executarRegras(EntidadeDominio entidade, List<IStrategy> rnsEntidade) {
        for (IStrategy rn : rnsEntidade) {
            String msg = rn.processar(entidade);
            if (msg != null) {
                sb.append(msg);
            }
        }
    }

}
