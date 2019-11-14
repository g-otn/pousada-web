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
        String dataEmissao = ((Reserva) entidade).getPagante().getCartao().getDataEmissao();
        String dataValidade = ((Reserva) entidade).getPagante().getCartao().getDataValidade();
        
        StringBuilder sb = new StringBuilder();
        
        YearMonth dataEmissaoYearMonth = null;
        YearMonth dataValidadeYearMonth = null;
        
        if (dataEmissao == null) {
            sb.append("cartaoDataEmissao: A data de emissão é obrigatória\n");
        } else {
            try {
                dataEmissaoYearMonth = YearMonth.parse(dataEmissao, DateTimeFormatter.ofPattern("MM/yy"));
            } catch (DateTimeParseException e) {
                sb.append("cartaoDataEmissao: A data de emissão é inválida\n");
            }
        }
        
        if (dataValidade == null) {
            sb.append("cartaoDataValidade: A data de validade é obrigatória\n");
        } else {
            try {
                dataValidadeYearMonth = YearMonth.parse(dataValidade, DateTimeFormatter.ofPattern("MM/yy"));
            } catch (DateTimeParseException e) {
                sb.append("cartaoDataValidade: A data de validade é inválida\n");
            }
        }
        
        // Validar intervalo entre datas inválido
        if (dataEmissaoYearMonth != null && dataValidadeYearMonth != null && 
                dataEmissaoYearMonth.isAfter(dataValidadeYearMonth)) {
            sb.append("cartaoDataEmissao: O intervalo entre as datas é inválido\n");
        } else if (dataValidadeYearMonth.isBefore(YearMonth.now())) {
            sb.append("cartaoDataValidade: O cartão está vencido\n");
        }
        
        return sb.toString();
    }
    
}
