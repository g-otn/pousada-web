package br.com.gotn.pousada.negocio.impl.reserva;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.LocalDateTime;
import java.util.List;

public class ValidarQuartos implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarQuartosOcupado#processar");
        List<Quarto> quartos = ((Reserva) entidade).getQuartos();
        LocalDateTime dataCheckIn = ((Reserva) entidade).getDataCheckIn();
        LocalDateTime dataCheckOut = ((Reserva) entidade).getDataCheckOut();
        StringBuilder sb = new StringBuilder();
        
        if (quartos == null) {
            sb.append("quartos: Seleção de quartos inválida\n");
        } else if (quartos.isEmpty()) {
            sb.append("quartos: É obrigatório escolher pelo menos um quarto\n");
        } else if (false) { // Verificar capacidade com DAO
            sb.append("quartos: A quantidade de hóspedes ultrapassa a capacidade somada dos quartos\n");
        } else if (false) { // Verificar com DAO quais quartos estão disponíveis naquele intervalo de tempo
            sb.append("quartos: Um ou mais quartos não estão disponíveis durante o período especificado\n");
        }
        
        
        
        return sb.toString();
    }
    
}