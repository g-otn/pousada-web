package br.com.gotn.pousada.negocio;

import br.com.gotn.pousada.dominio.EntidadeDominio;

public interface IStrategy {

  public String processar(EntidadeDominio entidade);

}
