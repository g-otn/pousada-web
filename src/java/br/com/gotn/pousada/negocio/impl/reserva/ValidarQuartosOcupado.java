package br.com.gotn.pousada.negocio.impl.reserva;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.LocalDateTime;
import java.util.List;

public class ValidarQuartosOcupado implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarQuartosOcupado#processar");
        List<Quarto> quartos = ((Reserva) entidade).getQuartos();
        LocalDateTime dataCheckIn = ((Reserva) entidade).getDataCheckIn();
        LocalDateTime dataCheckOut = ((Reserva) entidade).getDataCheckOut();
        StringBuilder sb = new StringBuilder();
        
        
        // Verificar com DAO quais quartos estão disponíveis naquele intervalo de tempo
        
        
        return sb.toString();
    }
    
}