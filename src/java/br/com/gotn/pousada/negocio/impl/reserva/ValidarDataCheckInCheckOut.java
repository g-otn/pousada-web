package br.com.gotn.pousada.negocio.impl.reserva;

import br.com.gotn.pousada.dao.impl.ReservaDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.LocalDateTime;

public class ValidarDataCheckInCheckOut implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDataCheckInCheckOut#processar");
        LocalDateTime dataCheckIn = ((Reserva) entidade).getDataCheckIn();
        LocalDateTime dataCheckOut = ((Reserva) entidade).getDataCheckOut();
        ReservaDAO reservaDAO = new ReservaDAO();
        StringBuilder sb = new StringBuilder();
        
        if (dataCheckIn == null || dataCheckOut == null) {
            sb.append("dataCheckInOut: A data de check-in e/ou de check-out é inválida\n");
        } else if (dataCheckIn.isAfter(dataCheckOut)) {
            sb.append("dataCheckInOut: A data de check-in deve ser anterior a de check-out\n");
        } else if (reservaDAO.consultar(entidade).isEmpty()) {
            sb.append("dataCheckInOut: Já existe uma reserva utilizando ao menos um destes quartos nesses períodos\n");
        }
        
        return sb.toString();
    }
    
}
