package br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidarDatasCartao implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDatasCartao#processar");
        YearMonth dataEmissao = ((Reserva) entidade).getPagante().getCartao().getDataEmissao();
        YearMonth dataValidade = ((Reserva) entidade).getPagante().getCartao().getDataValidade();
        
        StringBuilder sb = new StringBuilder();
        
        // Validar intervalo entre datas
        if (dataEmissaoYearMonth.isAfter(dataValidadeYearMonth)) {
            sb.append("cartaoDataEmissao: O intervalo entre as datas é inválido\n");
        } else if (dataValidadeYearMonth.isBefore(YearMonth.now())) {
            sb.append("cartaoDataValidade: O cartão está vencido\n");
        }
        
        return sb.toString();
    }
    
}
