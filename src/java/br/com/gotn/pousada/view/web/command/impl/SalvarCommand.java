package br.com.gotn.pousada.view.web.command.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.command.ICommand;

public class SalvarCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidadeDominio) {
        System.out.println("--> SalvarCommand#executar");
        return fachada.salvar(entidadeDominio);
    }
    
}
