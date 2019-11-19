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

        // *****************************************************************************************
        
        // Mapeando viewHelpers para os seus respectivos caminhos
        viewHelperMap.put("/reservas", new ReservaVH());
        viewHelperMap.put("/quartos", new QuartoVH());
        viewHelperMap.put("/categorias", new CategoriaVH());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("\n=================================");
        
        // Retorna o caminho sem a parte da aplicação ou da servlet (http://localhost:8080/ReservasPousada/Servlet/reservas -> /reservas)
        String caminho = request.getPathInfo(); 

        // Retorna a operação desejada (salvar, excluir, alterar ou consultar)
        String operacao = request.getParameter("operacao");
        
        System.out.println("==== Nova requisição POST para " + caminho);
        System.out.println("==== Operação: " + operacao);
        
        // *****************************************************************************************
        
        // Retorna a viewHelper designada para o caminho da requisição
        IViewHelper viewHelper = viewHelperMap.get(caminho);
        
        // Caminho não maepado (não encontrado em viewHelperMap)
        if (viewHelper == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // HTTP 404
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
            response.setStatus(422); // HTTP 422: Entidade improcessável (Sintaxe correta porém dados inválidos (operação inválida))
            System.out.println("==== command nao encontrado para o caminho " + caminho);
            System.out.println("=================================\n");
            return;
        }
        System.out.println("==== command recuperado: " + command.getClass().getSimpleName());
        
        // *****************************************************************************************
        
        // Retorna o resultado da entidade que foi executada e processada
        Resultado resultado = command.executar(entidade);
        System.out.println("==== Resultado: " + resultado.getEntidades().size() + " entidades, " + resultado.getMensagens().split("\n").length + " mensagens" );
        
        // Envia o resultado para a viewHelper que continuará o tratamento da requisição e enviará uma resposta
        viewHelper.setView(resultado, request, response);
        
        System.out.println("=================================\n");
    }

}
