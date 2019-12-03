package br.com.gotn.pousada.dominio;

import java.util.List;

public class QuartoECategorias extends EntidadeDominio {
    
    private Quarto quarto;
    private List<Categoria> categorias;

    public QuartoECategorias(long id) {
        this.setId(id);
    }

    public QuartoECategorias(Quarto quarto, List<Categoria> categorias) {
        this.quarto = quarto;
        this.categorias = categorias;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    

    @Override
    public String toString() {
        return "QuartoECategorias{" + "quarto=" + quarto + ", categorias=" + categorias + '}';
    }
    
}
