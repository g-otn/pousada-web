package br.com.gotn.pousada.negocio.impl.quarto;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarCategoriaQuarto implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarCategoriaQuarto#processar");
        Categoria categoria = ((Quarto) entidade).getCategoria();
        StringBuilder sb = new StringBuilder();
        
        if (categoria == null || categoria.getId() == 0L) {
            sb.append("categoria: A categoria é obrigatória\n");
        } else {
            // TODO: Verificar existência com DAO
        }
        
        return sb.toString();
    }
    
}
