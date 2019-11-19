package br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.Year;
import java.time.YearMonth;

public class ValidarDatasCartao implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDatasCartao#processar");
        YearMonth dataEmissao = ((Reserva) entidade).getPagante().getCartao().getDataEmissao();
        YearMonth dataValidade = ((Reserva) entidade).getPagante().getCartao().getDataValidade();

        StringBuilder sb = new StringBuilder();

        if (dataEmissao == null) {
            sb.append("cartaoDataEmissao: A data de emissão é obrigatória\n");
        } else if (dataEmissao.getYear() == Year.MIN_VALUE) {
            sb.append("cartaoDataEmissao: A data é inválida\n");
        }

        if (dataValidade == null) {
            sb.append("cartaoDataValidade: A data de validade é obrigatória\n");
        } else if (dataValidade.getYear() == Year.MIN_VALUE) {
            sb.append("cartaoDataValidade: A data é inválida\n");
        }

        if (sb.length() == 0) {
            // Validar intervalo entre datas
            if (dataEmissao.isAfter(dataValidade)) {
                sb.append("cartaoDataEmissao: O intervalo entre as datas é inválido\n");
            } else if (dataValidade.isBefore(YearMonth.now())) {
                sb.append("cartaoDataValidade: O cartão está vencido\n");
            }
        }

        return sb.toString();
    }

}
