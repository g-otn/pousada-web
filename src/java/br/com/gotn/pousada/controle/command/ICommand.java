package br.com.gotn.pousada.controle.command;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;

public interface ICommand {

    public Resultado executar(EntidadeDominio entidade);

}
