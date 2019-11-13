package br.com.gotn.pousada.negocio.impl.reserva.pagante;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Pagante;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarEmail implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidaEmail#processar");
        Reserva reserva = (Reserva) entidade;
        Pagante pagante = reserva.getPagante();
    }
    
}