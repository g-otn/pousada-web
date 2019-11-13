package br.com.gotn.pousada.negocio.impl.reserva.pagante.endereco;

import br.com.gotn.pousada.dominio.Endereco;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarCEP implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarCEP#processar");
        Reserva reserva = (Reserva) entidade;
    }
    
}