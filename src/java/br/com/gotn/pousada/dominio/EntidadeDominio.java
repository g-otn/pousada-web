package br.com.gotn.pousada.dominio;

public class EntidadeDominio {

    private long id;

    // *****************************************************************************************

    public EntidadeDominio() {
    }

    public EntidadeDominio(long id) {
        this.id = id;
    }

    // *****************************************************************************************
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
