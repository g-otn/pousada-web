package br.com.gotn.pousada.negocio.impl.reserva;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.LocalDateTime;

public class ValidarDataCheckInCheckOut implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDataCheckInCheckOut#processar");
        Reserva reserva = (Reserva) entidade;
    }
    
}
