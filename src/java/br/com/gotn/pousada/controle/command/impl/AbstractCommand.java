package br.com.gotn.pousada.controle.command.impl;

import br.com.gotn.pousada.controle.command.ICommand;
import br.com.gotn.pousada.controle.fachada.IFachada;
import br.com.gotn.pousada.controle.fachada.impl.Fachada;

public abstract class AbstractCommand implements ICommand {
    
    protected IFachada fachada = new Fachada();
    
}
