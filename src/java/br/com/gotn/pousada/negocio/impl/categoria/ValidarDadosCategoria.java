package br.com.gotn.pousada.negocio.impl.categoria;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDadosCategoria implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosCategoria#processar");
        Categoria categoria = (Categoria) entidade;
        StringBuilder sb = new StringBuilder();
        
        if (categoria.getCapacidade() < 1) {
            sb.append("capacidade: A capacidade é inválida\n");
        }
        
        if (categoria.getPrecoDiaria() < 0.0) {
            sb.append("precoDiaria: O preço da diária é inválido\n");
        }
        
        return sb.toString();
    }
    
}
