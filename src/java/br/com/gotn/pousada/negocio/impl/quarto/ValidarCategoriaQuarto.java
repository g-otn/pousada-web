package br.com.gotn.pousada.negocio.impl.quarto;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDadosQuarto implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosQuarto#processar");
        Quarto quarto = (Quarto) entidade;
        StringBuilder msg = new StringBuilder();
        
        if (quarto.getNumero() == null || quarto.getNumero().trim().isEmpty()) {
            msg.append("numero: O número do quarto é obrigatório\n");
        }
        
        if (quarto.getCategoria() == null || quarto.getCategoria().getId() == 0) {
            msg.append("categoria: A categoria do quarto é obrigatória\n");
        }
        
        return msg.toString();
    }
    
}
