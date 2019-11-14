package br.com.gotn.pousada.negocio.impl.categoria;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDescricaoCategoria implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosCategoria#processar");
        Categoria categoria = (Categoria) entidade;
        StringBuilder sb = new StringBuilder();
        
        if (categoria.getDescricao() == null || categoria.getDescricao().trim().isEmpty()) {
            sb.append("descricao: A descrição é obrigatória\n");
        } else {
            // TODO: Verificar repetido com DAO
        }
        
        return sb.toString();
    }
    
}
