package br.com.gotn.pousada.dominio;

public class Categoria extends EntidadeDominio {
  
  private String descricao;
  private double precoDiaria;
  private String capacidade;
  
  // *****************************************************************************************

  public Categoria(String descricao, double precoDiaria, String capacidade) {
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

  public String getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(String capacidade) {
    this.capacidade = capacidade;
  }
  
}
