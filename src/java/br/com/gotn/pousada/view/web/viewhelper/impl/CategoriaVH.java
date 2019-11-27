package br.com.gotn.pousada.view.web.viewhelper.impl;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.viewhelper.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        System.out.println("--> CategoriaVH#getEntidade");
        String operacao = request.getParameter("operacao");
        System.out.println("operacao: " + operacao);
        
        System.out.println("preco:" + request.getParameter("precoDiaria"));
        
        if (operacao == null) operacao = "consultar"; // Para poder realizar consulta utilizando o menu

        // *****************************************************************************************
        
        if (operacao.equals("salvar")) {
            // Categoria.descricao
            String descricao = request.getParameter("descricao") != null ? request.getParameter("descricao").trim() : null;
            
            // Categoria.precoDiaria
            double precoDiaria;
            try {
                precoDiaria = Double.parseDouble(request.getParameter("precoDiaria"));
            } catch (NumberFormatException e) {
                precoDiaria = -1.0;
            }
            
            // Categoria.capacidade
            int capacidade;
            try {
                capacidade = Integer.parseInt(request.getParameter("capacidade"));
            } catch (NumberFormatException e) {
                capacidade = -1;
            }
            
            // Entidade a ser retornada
            Categoria categoria = new Categoria(descricao, precoDiaria, capacidade);
            System.out.println(categoria);
            return categoria;
        }

        // *****************************************************************************************
        
        if (operacao.equals("alterar")) {
            // Categoria.descricao
            String descricao = request.getParameter("descricao") != null ? request.getParameter("descricao").trim() : null;
            
            // Categoria.precoDiaria
            double precoDiaria;
            try {
                precoDiaria = Double.parseDouble(request.getParameter("precoDiaria"));
            } catch (NumberFormatException e) {
                precoDiaria = -1.0;
            }
            
            // Categoria.capacidade
            int capacidade;
            try {
                capacidade = Integer.parseInt(request.getParameter("capacidade"));
            } catch (NumberFormatException e) {
                capacidade = -1;
            }
            
            Categoria categoria = new Categoria(descricao, precoDiaria, capacidade);
            
            // Categoria.id
            long idCategoria;
            try {
                idCategoria = Long.parseLong(request.getParameter("idCategoria"));
            } catch (NumberFormatException e) {
                idCategoria = -1L;
            }
            
            // Entidade a ser retornada
            categoria.setId(idCategoria);
            System.out.println(categoria);
            return categoria;
        }

        // *****************************************************************************************
        
        if (operacao.equals("excluir")) {
            // Categoria.id
            long idCategoria;
            try {
                idCategoria = Long.parseLong(request.getParameter("idCategoria"));
            } catch (NumberFormatException e) {
                idCategoria = -1L;
            }
            
            // Entidade a ser retornada
            Categoria categoria = new Categoria(idCategoria);
            System.out.println(categoria);
            return categoria;
        }

        // *****************************************************************************************
        
        if (operacao.equals("consultar")) {
            // Categoria.id
            long idCategoria;
            try {
                idCategoria = Long.parseLong(request.getParameter("idCategoria"));
            } catch (NumberFormatException e) {
                idCategoria = -1L;
            }
            
            // Entidade a ser retornada
            Categoria categoria = new Categoria(idCategoria);
            System.out.println(categoria);
            return categoria;
        }
        
        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("--> CategoriaVH#setView");
        String operacao = request.getParameter("operacao");
        
        if (operacao == null) operacao = "consultar"; // Para poder realizar consulta utilizando o menu
        
        try {
            if (operacao.equals("salvar")) {
                if (resultado.getMensagens() == null || resultado.getMensagens().trim().isEmpty()) {
                    request.setAttribute("sucesso", true);
                    response.sendRedirect(request.getContextPath() + "/categorias");
                } else {
                    request.getRequestDispatcher("/formularios/form-categoria.jsp").forward(request, response);
                }
            } else if (operacao.equals("alterar")) {
                if (resultado.getMensagens() == null || resultado.getMensagens().trim().isEmpty()) {
                    request.setAttribute("sucesso", true);
                    response.sendRedirect(request.getContextPath() + "/categorias");
                } else {
                    request.getRequestDispatcher("/formularios/form-categoria.jsp").forward(request, response);
                }
            } else if (operacao.equals("excluir")) {
                request.setAttribute("sucesso", true);
                response.sendRedirect(request.getContextPath() + "/categorias");
            } else if (operacao.equals("consultar")) {
                if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                    request.getRequestDispatcher("/tabelas/tabela-categorias.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/categorias/novo");
                }
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    
}
