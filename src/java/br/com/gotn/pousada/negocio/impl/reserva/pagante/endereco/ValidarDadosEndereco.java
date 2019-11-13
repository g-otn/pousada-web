package br.com.gotn.pousada.negocio.impl.reserva.pagante.endereco;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDadosEndereco implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosEndereco#processar");
        Reserva reserva = (Reserva) entidade;
    }
    