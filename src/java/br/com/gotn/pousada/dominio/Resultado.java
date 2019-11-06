package br.com.gotn.pousada.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Resultado {

    private HashMap<String, String> mensagens;
    private List<EntidadeDominio> entidades;

    // *****************************************************************************************
    
    public void addEntidade(EntidadeDominio entidade) {
        if (entidades == null) {
            entidades = new ArrayList<EntidadeDominio>();
        }
        entidades.add(entidade);
    }

    // *****************************************************************************************
    
    public HashMap<String, String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(HashMap<String, String> mensagens) {
        this.mensagens = mensagens;
    }

    public List<EntidadeDominio> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<EntidadeDominio> entidades) {
        this.entidades = entidades;
    }

}
