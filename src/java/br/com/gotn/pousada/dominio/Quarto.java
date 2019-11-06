package br.com.gotn.pousada.dominio;

public class Quarto extends EntidadeDominio {

    private String numero;
    private Categoria categoria;

    // *****************************************************************************************
    
    public Quarto(String numero, Categoria categoria) {
        this.numero = numero;
        this.categoria = categoria;
    }

    // *****************************************************************************************
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}