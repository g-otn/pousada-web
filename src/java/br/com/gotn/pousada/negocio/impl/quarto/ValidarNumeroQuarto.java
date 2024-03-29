package br.com.gotn.pousada.negocio.impl.quarto;

import br.com.gotn.pousada.dao.impl.QuartoDAO;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarNumeroQuarto implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarNumeroQuarto#processar");
        String numeroQuarto = ((Quarto) entidade).getNumero();
        QuartoDAO quartoDAO = new QuartoDAO();
        StringBuilder sb = new StringBuilder();
        
        if (numeroQuarto == null || numeroQuarto.trim().isEmpty()) {
            sb.append("numero: O número do quarto é obrigatório\n");
        } else if (quartoDAO.consultar(entidade).size() > 1) {
            sb.append("numero: Já existe um quarto com esse número\n");
        }
        
        return sb.toString();
    }
    
}
