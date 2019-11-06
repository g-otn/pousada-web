/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gotn.pousada.view.web.viewhelper;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IViewHelper {

  public EntidadeDominio getEntidade(HttpServletRequest request);

  public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response);

}
