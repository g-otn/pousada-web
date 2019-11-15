package br.com.gotn.pousada.negocio.impl.reserva.pagante;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.util.regex.Pattern;

public class ValidarEmail implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidaEmail#processar");
        String email = ((Reserva) entidade).getPagante().getEmail();
        StringBuilder sb = new StringBuilder();

        if (email == null || email.trim().isEmpty()) {
            sb.append("paganteEmail: O email é obrigatório\n");
        } else if (!ehEmail(email)) {
            sb.append("paganteEmail: O email é inválido\n");
        }
        
        return sb.toString();
    }
    
    public static boolean ehEmail(String email) {
        Pattern regexEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return regexEmail.matcher(email).find();
    }
    
}