package br.com.gotn.pousada.view.web.viewhelper.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.viewhelper.IViewHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        System.out.println("--> ReservaVH#getEntidade");
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("--> ReservaVH#setView");
    }
    
}