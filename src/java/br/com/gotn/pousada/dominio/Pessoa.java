package br.com.gotn.pousada.dominio;

public class Pessoa extends EntidadeDominio {

    private String nome;

    // *****************************************************************************************
    
    public Pessoa(long id) {
        super(id);
    }
    
    public Pessoa(String nome) {
        this.nome = nome;
    }

    // *****************************************************************************************
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + getId() + ", nome=" + nome + '}';
    }
    
}
