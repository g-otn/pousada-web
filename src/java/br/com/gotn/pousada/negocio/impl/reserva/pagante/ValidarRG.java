package br.com.gotn.pousada.negocio.impl.reserva.pagante;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarRG implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarRG#processar");
        String rg = ((Reserva) entidade).getPagante().getRg();
        StringBuilder sb = new StringBuilder();

        if (rg == null || rg.trim().isEmpty()) {
            sb.append("paganteRG: O RG é obrigatório\n");
        } else if (rg.length() > 14 || rg.length() < 8) {
            sb.append("paganteRG: O RG é inválido\n");
        } else {
            try {
                Integer.parseInt(rg);
            } catch (NumberFormatException e) {
                sb.append("paganteRG: O RG só pode conter digitos\n");
            }
        }
        
        return sb.toString();
    }
    
}