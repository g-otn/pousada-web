package br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarNumeroCartao implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarNumeroCartao#processar");
        String numeroCartao = ((Reserva) entidade).getPagante().getCartao().getNumero();
        
        StringBuilder sb = new StringBuilder();
        
        if (numeroCartao == null || numeroCartao.trim().isEmpty()) {
            sb.append("cartaoNumero: O número do cartão é obrigatório\n");
        } else if (numeroCartao.length() != 16) {
            sb.append("cartaoNumero: O número do cartão é inválido\n");
        }
        
        return sb.toString();
    }
    
}
