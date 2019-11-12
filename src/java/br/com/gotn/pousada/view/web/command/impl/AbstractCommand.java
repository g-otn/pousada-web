package br.com.gotn.pousada.view.web.command.impl;

import br.com.gotn.pousada.view.web.command.ICommand;
import br.com.gotn.pousada.view.web.fachada.IFachada;
import br.com.gotn.pousada.view.web.fachada.impl.Fachada;

public abstract class AbstractCommand implements ICommand {
    
    protected IFachada fachada = new Fachada();
    
}
