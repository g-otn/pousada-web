package br.com.gotn.pousada.view.web.viewhelper.impl;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.viewhelper.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuartoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        System.out.println("--> QuartoVH#getEntidade");
        String operacao = request.getParameter("operacao");
        System.out.println("operacao: " + operacao);
        
        if (operacao == null) operacao = "consultar"; // Para poder realizar consulta utilizando o menu

        // *****************************************************************************************
        
        if (operacao.equals("salvar")) {
            // Quarto.numero
            String numero = request.getParameter("numero") != null ? request.getParameter("numero").trim() : null;

            // Quarto.categoria
            long idCategoria;
            try {
                idCategoria = Long.parseLong(request.getParameter("idCategoria"));
            } catch (NumberFormatException e) {
                idCategoria = -1L;
            }
            Categoria categoria = new Categoria(idCategoria);
            
            // Entidade a ser retornada
            Quarto quarto = new Quarto(numero, categoria);
            System.out.println(quarto);
            return quarto;
        }

        // *****************************************************************************************
        
        if (operacao.equals("alterar")) {
            // Quarto.numero
            String numero = request.getParameter("numero") != null ? request.getParameter("numero").trim() : null;

            // Quarto.categoria
            long idCategoria;
            try {
                idCategoria = Long.parseLong(request.getParameter("idCategoria"));
            } catch (NumberFormatException e) {
                idCategoria = -1L;
            }
            Categoria categoria = new Categoria(idCategoria);
            
            Quarto quarto = new Quarto(numero, categoria);
            
            // Quarto.id
            long idQuarto;
            try {
                idQuarto = Long.parseLong(request.getParameter("idQuarto"));
            } catch (NumberFormatException e) {
                idQuarto = -1L;
            }
            quarto.setId(idQuarto);
            
            // Entidade a ser retornada
            System.out.println(quarto);
            return quarto;
        }

        // *****************************************************************************************
        
        if (operacao.equals("excluir")) {
            // Quarto.id
            long idQuarto;
            try {
                idQuarto = Long.parseLong(request.getParameter("idQuarto"));
            } catch (NumberFormatException e) {
                idQuarto = -1L;
            }
            
            // Entidade a ser retornada
            Quarto quarto = new Quarto(idQuarto);
            System.out.println(quarto);
            return quarto;
        }

        // *****************************************************************************************
        
        if (operacao.equals("consultar")) {
            // Quarto.id
            long idQuarto;
            try {
                idQuarto = Long.parseLong(request.getParameter("idQuarto"));
            } catch (NumberFormatException e) {
                idQuarto = -1L;
            }
            
            // Entidade a ser retornada
            Quarto quarto = new Quarto(idQuarto);
            System.out.println(quarto);
            return quarto;
        }
        
        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("--> QuartoVH#setView");
        String operacao = request.getParameter("operacao");
        
        if (operacao == null) operacao = "consultar"; // Para poder realizar consulta utilizando o menu
        
        request.setAttribute("resultado", resultado);
        
        try {
            if (operacao.equals("salvar")) {
                if (resultado.getMensagens() == null || resultado.getMensagens().trim().isEmpty()) {
                    request.setAttribute("sucesso", true);
                    response.sendRedirect(request.getContextPath() + "/quartos");
                } else {
                    request.getRequestDispatcher("/formularios/form-quarto.jsp").forward(request, response);
                }
            } else if (operacao.equals("alterar")) {
                if (resultado.getMensagens() == null || resultado.getMensagens().trim().isEmpty()) {
                    request.setAttribute("sucesso", true);
                    response.sendRedirect(request.getContextPath() + "/quartos");
                } else {
                    request.getRequestDispatcher("/formularios/form-quarto.jsp").forward(request, response);
                }
            } else if (operacao.equals("excluir")) {
                request.setAttribute("sucesso", true);
                response.sendRedirect(request.getContextPath() + "/quartos");
            } else if (operacao.equals("consultar")) {
                if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                    request.getRequestDispatcher("/tabelas/tabela-quartos.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/quartos/novo");
                }
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    
}
