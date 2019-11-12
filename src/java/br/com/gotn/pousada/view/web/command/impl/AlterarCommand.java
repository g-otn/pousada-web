package br.com.gotn.pousada.view.web.command.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.command.ICommand;

public class AlterarCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidadeDominio) {
        System.out.println("--> AlterarCommand#executar");
        return fachada.alterar(entidadeDominio);
    }
    
}
