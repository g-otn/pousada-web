package br.com.gotn.pousada.negocio.impl.quarto;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarNumeroExistente implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarNumeroExistente#processar");
        Quarto quarto = (Quarto) entidade;
    }
    
}
