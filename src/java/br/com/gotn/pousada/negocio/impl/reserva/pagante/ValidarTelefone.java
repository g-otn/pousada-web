package br.com.gotn.pousada.negocio.impl.reserva.pagante;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Pagante;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarTelefone implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarTelefone#processar");
        String telefone = ((Reserva) entidade).getPagante().getTelefone();
        StringBuilder sb = new StringBuilder();

        if (telefone == null || telefone.trim().isEmpty()) {
            sb.append("paganteTelefone: O telefone é obrigatório\n");
        } else if (telefone.length() < 8 || telefone.length() > 14) {
            sb.append("paganteTelefone: O telefone é inválido\n");
        } else {
            try {
                Integer.parseInt(telefone);
            } catch (NumberFormatException e) {
                sb.append("paganteTelefone: O telefone só pode conter digitos\n");
            }
        }
        
        return sb.toString();
    }
    
}