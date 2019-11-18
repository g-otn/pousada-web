package br.com.gotn.pousada.dominio;

public class Categoria extends EntidadeDominio {

    private String descricao;
    private double precoDiaria;
    private int capacidade;

    // *****************************************************************************************
    
    public Categoria(long id) {
        super(id);
    }
    
    public Categoria(String descricao, double precoDiaria, int capacidade) {
        this.descricao = descricao;
        this.precoDiaria = precoDiaria;
        this.capacidade = capacidade;
    }

    // *****************************************************************************************
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Categoria{id=" + getId() + ", descricao=" + descricao + ", precoDiaria=" + precoDiaria + ", capacidade=" + capacidade + '}';
    }

}
