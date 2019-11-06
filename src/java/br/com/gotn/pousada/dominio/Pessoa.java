package br.com.gotn.pousada.dominio;

public class Pessoa extends EntidadeDominio {
  
  private String nome;
  
  // *****************************************************************************************

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
}
