package br.com.gotn.pousada.controle.command.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.controle.command.ICommand;

public class AlterarCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidade) {
        System.out.println("--> AlterarCommand#executar");
        return fachada.alterar(entidade);
    }
    
}