package br.com.gotn.pousada.negocio.impl.reserva;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDadosReserva implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosReserva#processar");
        Reserva reserva = (Reserva) entidade;
    }
    
}
