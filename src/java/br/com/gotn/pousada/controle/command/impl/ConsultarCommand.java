package br.com.gotn.pousada.controle.command.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;

public class ConsultarCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidade) {
        System.out.println("--> ConsultarCommand#executar");
        return fachada.consultar(entidade);
    }
    
}
