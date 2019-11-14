package br.com.gotn.pousada.dominio;

import java.time.LocalDate;
import java.time.YearMonth;

public class Cartao extends EntidadeDominio {

    private String numero;
    private YearMonth dataEmissao;
    private YearMonth dataValidade;
    private String codigoSeguranca;

    // *****************************************************************************************
    public Cartao(String numero, YearMonth dataEmissao, YearMonth dataValidade, String codigoSeguranca) {
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

    public YearMonth getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(YearMonth dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public YearMonth getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(YearMonth dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

}
