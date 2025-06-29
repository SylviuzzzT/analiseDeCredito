package com.bank.demo.domain.model;

public class Renda {

    private ModalidadeRenda modalidade;
    private double valor;
    private boolean recorrente;


    public Renda(ModalidadeRenda modalidade, double valor, boolean recorrente) {
        this.modalidade = modalidade;
        this.valor = valor;
        this.recorrente = recorrente;
    }

    public ModalidadeRenda getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeRenda modalidade) {
        this.modalidade = modalidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }

    @Override
    public String toString() {
        return "Renda{" +
                "modalidade='" + modalidade + '\'' +
                ", valor=" + valor +
                ", recorrente=" + recorrente +
                '}';
    }
}
