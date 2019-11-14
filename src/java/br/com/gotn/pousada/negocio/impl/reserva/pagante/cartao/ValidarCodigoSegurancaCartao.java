package br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarCodigoSegurancaCartao implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarNumeroCartao#processar");
        String codigoSeguranca = ((Reserva) entidade).getPagante().getCartao().getCodigoSeguranca();
        
        StringBuilder sb = new StringBuilder();
        
        if (codigoSeguranca == null || codigoSeguranca.trim().isEmpty()) {
            sb.append("cartaoCodigoSeguranca: O código de segurança é obrigatório\n");
        } else if (codigoSeguranca.length() != 3) {
            sb.append("cartaoCodigoSeguranca: O código de segurança é inválido\n");
        } else {
            try {
                Integer.parseInt(codigoSeguranca);
            } catch (NumberFormatException e) {
                sb.append("cartaoCodigoSeguranca: O código de segurança deve ser um número\n");
            }
        }
        
        return sb.toString();
    }
    
}
