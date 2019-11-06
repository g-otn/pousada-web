package br.com.gotn.pousada.view.web.command;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;

public interface ICommand {

  public Resultado executar(EntidadeDominio entidadeDominio);

}
