package br.com.gotn.pousada.view.web.fachada;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Resultado;

public interface IFachada {

    public Resultado salvar(EntidadeDominio entidade);

    public Resultado alterar(EntidadeDominio entidade);

    public Resultado excluir(EntidadeDominio entidade);

    public Resultado consultar(EntidadeDominio entidade);

}
