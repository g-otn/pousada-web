package br.com.gotn.pousada.dominio;

import java.time.LocalDate;

public class Cartao extends EntidadeDominio {

    private String numero;
    private LocalDate dataEmissao;
    private LocalDate dataValidade;
    private String codigoSeguranca;

    // *****************************************************************************************
    
    public Cartao(String numero, LocalDate dataEmissao, LocalDate dataValidade, String codigoSeguranca) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
        this.codigoSeguranca = codigoSeguranca;
    }

    // *****************************************************************************************
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

}
