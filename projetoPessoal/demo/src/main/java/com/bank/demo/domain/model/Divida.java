package com.bank.demo.domain.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Divida {
    private double valor;
    private String credor;
    private LocalDate vencimento;
    private boolean paga;

    public Divida(double valor, String credor, LocalDate vencimento, boolean paga) {
        this.valor = valor;
        this.credor = credor;
        this.vencimento = vencimento;
        this.paga = paga;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "valor=" + valor +
                ", credor='" + credor + '\'' +
                ", vencimento=" + vencimento +
                ", paga=" + paga +
                '}';
    }
}
