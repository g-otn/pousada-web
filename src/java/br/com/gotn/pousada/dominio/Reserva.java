package br.com.gotn.pousada.dominio;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;

public class Reserva extends EntidadeDominio {

    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private String observacoes;
    private List<Pessoa> pessoas;
    private Pagante pagante;
    private List<Quarto> quartos;

    // *****************************************************************************************
    
    public Reserva(LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, String observacoes, List<Pessoa> pessoas, Pagante pagante, List<Quarto> quartos) {
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.observacoes = observacoes;
        this.pessoas = pessoas;
        this.pagante = pagante;
        this.quartos = quartos;
    }

    public long getDias() {
        return (int) DAYS.between(dataCheckIn, dataCheckOut);
    }

    public double getPrecoTotal() {
        double precoTotal = 0.0;

        for (Quarto quarto : quartos) {
            precoTotal += quarto.getCategoria().getPrecoDiaria() * getDias();
        }

        return precoTotal;
    }

    // *****************************************************************************************
    
    public LocalDateTime getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDateTime dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDateTime getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDateTime dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pagante getPagante() {
        return pagante;
    }

    public void setPagante(Pagante pagante) {
        this.pagante = pagante;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

}
