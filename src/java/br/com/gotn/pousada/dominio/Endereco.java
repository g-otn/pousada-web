package br.com.gotn.pousada.dominio;

public class Endereco extends EntidadeDominio {

    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private Cidade cidade;

    // *****************************************************************************************
    
    public Endereco(long id) {
        super(id);
    }
    
    public Endereco(String bairro, String logradouro, String numero, String complemento, String cep, Cidade cidade) {
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    }

    // *****************************************************************************************
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{id=" + getId() + ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", cidade=" + cidade + '}';
    }

}
