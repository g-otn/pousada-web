package br.com.gotn.pousada.view.web.viewhelper.impl;

import br.com.gotn.pousada.dominio.Cartao;
import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.Cidade;
import br.com.gotn.pousada.dominio.Endereco;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Estado;
import br.com.gotn.pousada.dominio.Pagante;
import br.com.gotn.pousada.dominio.Pessoa;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.viewhelper.IViewHelper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        System.out.println("--> ReservaVH#getEntidade");
        String operacao = request.getParameter("operacao");
        System.out.println("operacao: " + operacao);

        if (operacao == null) operacao = "consultar"; // Para poder realizar consulta utilizando o menu

        // *****************************************************************************************
        
        if (operacao.equals("salvar")) {
            // Parse nas datas que veem concatenadas ("dataCheckIn - dataCheckOut")
            String datasConcatenadas = request.getParameter("dataCheckInOut");
            String[] datas = datasConcatenadas.split("-");

            // Reserva.dataCheckIn, Reserva.dataCheckOut
            LocalDateTime dataCheckIn, dataCheckOut;
            try {
                dataCheckIn = LocalDateTime.parse(datas[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a"));
                dataCheckOut = LocalDateTime.parse(datas[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a"));
            } catch (NullPointerException | DateTimeParseException e) {
                dataCheckIn = null;
                dataCheckOut = null;
            }

            // Reserva.observacoes
            String observacoes = request.getParameter("observacoes");

            // Reserva.pessoas
            List<Pessoa> pessoas = new ArrayList<>();
            try {
                String[] pessoasNomes = request.getParameterValues("hospedes");
                for (String pessoaNome : pessoasNomes) {
                    pessoas.add(new Pessoa(pessoaNome));
                }
            } catch (Exception e) {
                pessoas = null;
            }
            if (pessoas != null && pessoas.isEmpty()) {
                pessoas = null;
            }

            // Reserva.pagante
            String paganteNome = request.getParameter("paganteNome") != null ? request.getParameter("paganteNome").trim() : null;
            String paganteRg = request.getParameter("paganteRg") != null ? request.getParameter("paganteRg").trim() : null;
            String paganteCpf = request.getParameter("paganteCpf") != null ? request.getParameter("paganteCpf").trim() : null;
            String paganteEmail = request.getParameter("paganteEmail") != null ? request.getParameter("paganteEmail").trim() : null;
            String paganteTelefone = request.getParameter("paganteTelefone") != null ? request.getParameter("paganteTelefone").trim() : null;

            // Reserva.pagante.endereco
            String enderecoBairro = request.getParameter("enderecoBairro") != null ? request.getParameter("enderecoBairro").trim() : null;
            String enderecoLogradouro = request.getParameter("enderecoLogradouro") != null ? request.getParameter("enderecoLogradouro").trim() : null;
            String enderecoNumero = request.getParameter("enderecoNumero") != null ? request.getParameter("enderecoNumero").trim() : null;
            String enderecoComplemento = request.getParameter("enderecoComplemento") != null ? request.getParameter("enderecoComplemento").trim() : null;
            String enderecoCEP = request.getParameter("enderecoCEP") != null ? request.getParameter("enderecoCEP").trim() : null;
            String enderecoCidade = request.getParameter("enderecoCidade") != null ? request.getParameter("enderecoCidade").trim() : null;
            String enderecoEstado = request.getParameter("enderecoEstado") != null ? request.getParameter("enderecoEstado").trim() : null;
            
            // Reserva.pagante.cartao
            String cartaoNumero = request.getParameter("cartaoNumero") != null ? request.getParameter("cartaoNumero").trim() : null;
            YearMonth cartaoDataEmissao, cartaoDataValidade;
            try {
                cartaoDataEmissao = YearMonth.parse(request.getParameter("cartaoDataEmissao"), DateTimeFormatter.ofPattern("MM/yy"));
            } catch (DateTimeParseException e) {
                cartaoDataEmissao = YearMonth.of(Year.MIN_VALUE, 1); // Ano -999,999,999, marcado como inválido na validação
            }
            try {
                cartaoDataValidade = YearMonth.parse(request.getParameter("cartaoDataValidade"), DateTimeFormatter.ofPattern("MM/yy"));
            } catch (DateTimeParseException e) {
                cartaoDataValidade = YearMonth.of(Year.MIN_VALUE, 1); // Ano -999,999,999, marcado como inválido na validação
            }
            String cartaoCodigoSeguranca = request.getParameter("cartaoCodigoSeguranca") != null ? request.getParameter("cartaoCodigoSeguranca").trim() : null;
            
            // Reserva.quartos
            List<Quarto> quartos = new ArrayList<>();
            try {
                String[] quartoIdStrings = request.getParameterValues("quartos");
                for (String quartoIdString : quartoIdStrings) {
                    quartos.add(new Quarto(Long.parseLong(quartoIdString)));
                }
            } catch (NumberFormatException e) {
                quartos = null;
            }
            if (quartos != null && quartos.isEmpty()) {
                quartos = null;
            }
            
            Cartao cartao = new Cartao(cartaoNumero, cartaoDataEmissao, cartaoDataValidade, cartaoCodigoSeguranca);
            Estado estado = new Estado(enderecoEstado);
            Cidade cidade = new Cidade(enderecoCidade, estado);
            Endereco endereco = new Endereco(enderecoBairro, enderecoLogradouro, enderecoNumero, enderecoComplemento, enderecoCEP, cidade);
            Pagante pagante = new Pagante(paganteNome, paganteRg, paganteCpf, paganteEmail, paganteTelefone, endereco, cartao);

            // Entidade a ser retornada
            Reserva reserva = new Reserva(dataCheckIn, dataCheckOut, observacoes, pessoas, pagante, quartos);
            System.out.println(reserva);
            return reserva;
        }

        // *****************************************************************************************
        
        if (operacao.equals("alterar")) {
            // Parse nas datas que veem concatenadas ("dataCheckIn - dataCheckOut")
            String datasConcatenadas = request.getParameter("dataCheckInOut");
            String[] datas = datasConcatenadas.split("-");

            // Reserva.dataCheckIn, Reserva.dataCheckOut
            LocalDateTime dataCheckIn, dataCheckOut;
            try {
                dataCheckIn = LocalDateTime.parse(datas[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a"));
                dataCheckOut = LocalDateTime.parse(datas[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a"));
            } catch (NullPointerException | DateTimeParseException e) {
                dataCheckIn = null;
                dataCheckOut = null;
            }

            // Reserva.observacoes
            String observacoes = request.getParameter("observacoes");

            // Reserva.pessoas
            List<Pessoa> pessoas = new ArrayList<>();
            try {
                String[] pessoasNomes = request.getParameterValues("hospedes");
                for (String pessoaNome : pessoasNomes) {
                    pessoas.add(new Pessoa(pessoaNome));
                }
            } catch (Exception e) {
                pessoas = null;
            }
            if (pessoas != null && pessoas.isEmpty()) {
                pessoas = null;
            }

            // Reserva.pagante
            String paganteNome = request.getParameter("paganteNome") != null ? request.getParameter("paganteNome").trim() : null;
            String paganteRg = request.getParameter("paganteRg") != null ? request.getParameter("paganteRg").trim() : null;
            String paganteCpf = request.getParameter("paganteCpf") != null ? request.getParameter("paganteCpf").trim() : null;
            String paganteEmail = request.getParameter("paganteEmail") != null ? request.getParameter("paganteEmail").trim() : null;
            String paganteTelefone = request.getParameter("paganteTelefone") != null ? request.getParameter("paganteTelefone").trim() : null;

            // Reserva.pagante.endereco
            String enderecoBairro = request.getParameter("enderecoBairro") != null ? request.getParameter("enderecoBairro").trim() : null;
            String enderecoLogradouro = request.getParameter("enderecoLogradouro") != null ? request.getParameter("enderecoLogradouro").trim() : null;
            String enderecoNumero = request.getParameter("enderecoNumero") != null ? request.getParameter("enderecoNumero").trim() : null;
            String enderecoComplemento = request.getParameter("enderecoComplemento") != null ? request.getParameter("enderecoComplemento").trim() : null;
            String enderecoCEP = request.getParameter("enderecoCEP") != null ? request.getParameter("enderecoCEP").trim() : null;
            String enderecoCidade = request.getParameter("enderecoCidade") != null ? request.getParameter("enderecoCidade").trim() : null;
            String enderecoEstado = request.getParameter("enderecoEstado") != null ? request.getParameter("enderecoEstado").trim() : null;
            
            // Reserva.pagante.cartao
            String cartaoNumero = request.getParameter("cartaoNumero") != null ? request.getParameter("cartaoNumero").trim() : null;
            YearMonth cartaoDataEmissao, cartaoDataValidade;
            try {
                cartaoDataEmissao = YearMonth.parse(request.getParameter("cartaoDataEmissao"), DateTimeFormatter.ofPattern("MM/yy"));
            } catch (DateTimeParseException e) {
                cartaoDataEmissao = YearMonth.of(Year.MIN_VALUE, 1); // Ano -999,999,999, marcado como inválido na validação
            }
            try {
                cartaoDataValidade = YearMonth.parse(request.getParameter("cartaoDataValidade"), DateTimeFormatter.ofPattern("MM/yy"));
            } catch (DateTimeParseException e) {
                cartaoDataValidade = YearMonth.of(Year.MIN_VALUE, 1); // Ano -999,999,999, marcado como inválido na validação
            }
            String cartaoCodigoSeguranca = request.getParameter("cartaoCodigoSeguranca") != null ? request.getParameter("cartaoCodigoSeguranca").trim() : null;
            
            // Reserva.quartos
            List<Quarto> quartos = new ArrayList<>();
            try {
                String[] quartoIdStrings = request.getParameterValues("quartos");
                for (String quartoIdString : quartoIdStrings) {
                    quartos.add(new Quarto(Long.parseLong(quartoIdString)));
                }
            } catch (NumberFormatException e) {
                quartos = null;
            }
            if (quartos != null && quartos.isEmpty()) {
                quartos = null;
            }
            
            Cartao cartao = new Cartao(cartaoNumero, cartaoDataEmissao, cartaoDataValidade, cartaoCodigoSeguranca);
            Estado estado = new Estado(enderecoEstado);
            Cidade cidade = new Cidade(enderecoCidade, estado);
            Endereco endereco = new Endereco(enderecoBairro, enderecoLogradouro, enderecoNumero, enderecoComplemento, enderecoCEP, cidade);
            Pagante pagante = new Pagante(paganteNome, paganteRg, paganteCpf, paganteEmail, paganteTelefone, endereco, cartao);
            Reserva reserva = new Reserva(dataCheckIn, dataCheckOut, observacoes, pessoas, pagante, quartos);
            
            // Reserva.id
            long idReserva;
            try {
                idReserva = Long.parseLong(request.getParameter("idReserva"));
            } catch (NumberFormatException e) {
                idReserva = -1L;
            }
            reserva.setId(idReserva);

            // Entidade a ser retornada
            System.out.println(reserva);
            return reserva;
        }

        // *****************************************************************************************
        
        if (operacao.equals("excluir")) {
            // Reserva.id
            long idReserva;
            try {
                idReserva = Long.parseLong(request.getParameter("idReserva"));
            } catch (NumberFormatException e) {
                idReserva = -1L;
            }

            // Entidade a ser retornada
            Reserva reserva = new Reserva(idReserva);
            System.out.println(reserva);
            return reserva;
        }

        // *****************************************************************************************
        
        if (operacao.equals("consultar")) {
            // Reserva.id
            long idReserva;
            try {
                idReserva = Long.parseLong(request.getParameter("idReserva"));
            } catch (NumberFormatException e) {
                idReserva = -1L;
            }

            // Entidade a ser retornada
            Reserva reserva = new Reserva(idReserva);
            System.out.println(reserva);
            return reserva;
        }

        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("--> ReservaVH#setView");
        String operacao = request.getParameter("operacao");
        
        if (operacao == null) operacao = "consultar"; // Para poder realizar consulta utilizando o menu
        
        try {
            if (operacao.equals("salvar")) {
                if (resultado.getMensagens() == null || resultado.getMensagens().trim().isEmpty()) {
                    request.setAttribute("sucesso", true);
                    response.sendRedirect(request.getContextPath() + "/reservas");
                } else {
                    request.getRequestDispatcher("/formularios/form-reservas.jsp").forward(request, response);
                }
            } else if (operacao.equals("alterar")) {
                if (resultado.getMensagens() == null || resultado.getMensagens().trim().isEmpty()) {
                    request.setAttribute("sucesso", true);
                    response.sendRedirect(request.getContextPath() + "/reservas");
                } else {
                    request.getRequestDispatcher("/formularios/form-reservas.jsp").forward(request, response);
                }
            } else if (operacao.equals("excluir")) {
                request.setAttribute("sucesso", true);
                response.sendRedirect(request.getContextPath() + "/reservas");
            } else if (operacao.equals("consultar")) {
                if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/reservas");
                } else {
                    request.getRequestDispatcher("/formularios/form-reserva.jsp").forward(request, response);
                }
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
