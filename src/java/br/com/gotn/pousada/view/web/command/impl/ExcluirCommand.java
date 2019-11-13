package br.com.gotn.pousada.view.web.command.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.command.ICommand;

public class ExcluirCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidade) {
        System.out.println("--> ExcluirCommand#executar");
        return fachada.excluir(entidade);
    }
    
}
