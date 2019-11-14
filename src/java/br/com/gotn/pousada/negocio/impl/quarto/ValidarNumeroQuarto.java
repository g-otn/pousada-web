package br.com.gotn.pousada.negocio.impl.quarto;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarNumeroQuarto implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarNumeroExistente#processar");
        String numeroQuarto = ((Quarto) entidade).getNumero();
        StringBuilder sb = new StringBuilder();
        
        if (numeroQuarto == null || numeroQuarto.trim().isEmpty()) {
            sb.append("numero: O número do quarto é obrigatório\n");
        } else {
            // Validar repetido com DAO
        }
        
        return sb.toString();
    }
    
}
