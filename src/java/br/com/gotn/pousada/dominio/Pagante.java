package br.com.gotn.pousada.dominio;

public class Pagante extends Pessoa {

    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Cartao cartao;

    // *****************************************************************************************
    
    public Pagante(long id) {
        super(id);
    }
    
    public Pagante(String nome, String rg, String cpf, String email, String telefone, Endereco endereco, Cartao cartao) {
        super(nome);
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cartao = cartao;
    }

    // *****************************************************************************************
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

}
