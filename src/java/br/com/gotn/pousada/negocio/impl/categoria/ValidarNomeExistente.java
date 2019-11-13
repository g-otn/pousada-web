package br.com.gotn.pousada.negocio.impl.categoria;

import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarNomeExistente implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarNomeExistente#processar");
        Categoria categoria = (Categoria) entidade;
    }
    
}
