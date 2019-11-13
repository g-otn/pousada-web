package br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao;

import br.com.gotn.pousada.dominio.Cartao;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Pagante;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDatasCartao implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDatasCartao#processar");
        Reserva reserva = (Reserva) entidade;
        Pagante pagante = reserva.getPagante();
        Cartao cartao = pagante.getCartao();
    }
    
}
