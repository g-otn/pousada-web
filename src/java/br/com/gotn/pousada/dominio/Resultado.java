package br.com.gotn.pousada.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Resultado {

    private String mensagens;
    private List<EntidadeDominio> entidades;

    // *****************************************************************************************
    
    public void addEntidade(EntidadeDominio entidade) {
        if (entidades == null) {
            entidades = new ArrayList<EntidadeDominio>();
        }
        entidades.add(entidade);
    }

    // *****************************************************************************************
    
    public String getMensagens() {
        return mensagens;
    }

    public void setMensagens(String mensagens) {
        this.mensagens = mensagens;
    }

    public List<EntidadeDominio> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<EntidadeDominio> entidades) {
        this.entidades = entidades;
    }

}
