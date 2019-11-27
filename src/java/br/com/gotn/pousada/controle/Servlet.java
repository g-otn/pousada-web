package br.com.gotn.pousada.controle;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.view.web.command.ICommand;
import br.com.gotn.pousada.view.web.command.impl.AlterarCommand;
import br.com.gotn.pousada.view.web.command.impl.ConsultarCommand;
import br.com.gotn.pousada.view.web.command.impl.ExcluirCommand;
import br.com.gotn.pousada.view.web.command.impl.SalvarCommand;
import br.com.gotn.pousada.view.web.viewhelper.IViewHelper;
import br.com.gotn.pousada.view.web.viewhelper.impl.CategoriaVH;
import br.com.gotn.pousada.view.web.viewhelper.impl.QuartoVH;
import br.com.gotn.pousada.view.web.viewhelper.impl.ReservaVH;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Servlet", urlPatterns = {"/reservas/*", "/quartos/*", "/categorias/*"})
public class Servlet extends HttpServlet {
    
    private static final String CONTEXTO = "pousada";
    private final Map<String, ICommand> commandMap;
    private final Map<String, IViewHelper> viewHelperMap;

    public Servlet() {
        // Inicializando mapas
        viewHelperMap = new HashMap<>();
        commandMap = new HashMap<>();

        // *****************************************************************************************
        
        // Mapeando commands para suas respectivas operações
        commandMap.put("salvar", new SalvarCommand());
        commandMap.put("alterar", new AlterarCommand());
        commandMap.put("excluir", new ExcluirCommand());
        commandMap.put("consultar", new ConsultarCommand());
        commandMap.put(null, new ConsultarCommand());
        
        // *****************************************************************************************
        
        // Mapeando viewHelpers para os seus respectivos caminhos
        viewHelperMap.put("/" + CONTEXTO + "/reservas", new ReservaVH());
        viewHelperMap.put("/" + CONTEXTO + "/quartos", new QuartoVH());
        viewHelperMap.put("/" + CONTEXTO + "/categorias", new CategoriaVH());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("\n=================================");
        
        // Retorna o caminho com o contexto da aplicação e o mapeamento da servlet (http://localhost:8080/ReservasPousada/Servlet/reservas -> /ReservasPousada/Servlet/reservas)
        String caminho = request.getRequestURI(); 

        // Retorna a operação desejada (salvar, excluir, alterar ou consultar)
        String operacao = request.getParameter("operacao");
        
        System.out.println("==== Nova requisição POST para " + caminho);
        System.out.println("==== Operação: " + operacao);
        
        // *****************************************************************************************
        
        // Retorna a viewHelper designada para o caminho da requisição
        IViewHelper viewHelper = viewHelperMap.get(caminho);
        
        // Caminho não maepado (não encontrado em viewHelperMap)
        if (viewHelper == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Caminho inválido!"); // HTTP 404
            System.out.println("==== viewHelper nao encontrado para o caminho " + caminho);
            System.out.println("=================================\n");
            return;
        }
        System.out.println("==== viewHelper recuperado: " + viewHelper.getClass().getSimpleName());

        // Retorna a entidade instanciada e preenchida com os dados enviados na requisição
        EntidadeDominio entidade = viewHelper.getEntidade(request);
        System.out.println("==== entidade recuperada: " + entidade.getClass().getSimpleName());

        // Retorna a command designada para executar a operação
        ICommand command = commandMap.get(operacao);
        
        // Operação não suportada (não encontrada em commandMap)
        if (command == null) {
            response.sendError(422, "Operação inválida!"); // HTTP 422: Entidade improcessável (Sintaxe correta porém dados inválidos (operação inválida))
            System.out.println("==== command nao encontrado para o caminho " + caminho);
            System.out.println("=================================\n");
            return;
        }
        System.out.println("==== command recuperado: " + command.getClass().getSimpleName());
        
        // *****************************************************************************************
        
        // Retorna o resultado da entidade que foi executada e processada
        Resultado resultado = command.executar(entidade);
        System.out.println("==== Resultado: " + (resultado.getEntidades() != null ? resultado.getEntidades().size() : "null") + " entidades, " + (resultado.getMensagens() != null ? resultado.getMensagens().split("\n").length : "null") + " mensagens" );
        
        // Envia o resultado para a viewHelper que continuará o tratamento da requisição e enviará uma resposta
        viewHelper.setView(resultado, request, response);
        
        System.out.println("=================================\n");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet " + request.getRequestURL() + " | " + request.getParameter("operacao"));
        
        
        // Simplesmente redireciona para os formulários
        switch (request.getRequestURI()) {
            case "/" + CONTEXTO + "/reservas/novo":
                request.getRequestDispatcher("/formularios/form-reserva.jsp").forward(request, response);
                return;
            case "/" + CONTEXTO + "/quartos/novo":
                request.getRequestDispatcher("/formularios/form-quarto.jsp").forward(request, response);
                return;
            case "/" + CONTEXTO + "/categorias/novo":
                request.getRequestDispatcher("/formularios/form-categoria.jsp").forward(request, response);
                return;
            case "/" + CONTEXTO + "/reservas":
            case "/" + CONTEXTO + "/quartos":
            case "/" + CONTEXTO + "/categorias":
                // Consulta, permite ir para as tabelas a partir dos botões do menu
                doPost(request, response);
                return;
            default:
                request.getRequestDispatcher("/formularios/form-reserva.jsp").forward(request, response);
                return;
        }
    }

}
