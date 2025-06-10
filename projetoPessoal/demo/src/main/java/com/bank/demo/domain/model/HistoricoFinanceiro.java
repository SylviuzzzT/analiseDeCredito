package com.bank.demo.domain.model;

import java.util.List;

public class HistoricoFinanceiro {

    private List<Divida> dividas;
    private int emprestimosQuitados;
    private boolean temNomeSujo;

    public HistoricoFinanceiro(List<Divida> dividas, int emprestimosQuitados, boolean temNomeSujo) {
        this.dividas = dividas;
        this.emprestimosQuitados = emprestimosQuitados;
        this.temNomeSujo = temNomeSujo;
    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    public int getEmprestimosQuitados() {
        return emprestimosQuitados;
    }

    public void setEmprestimosQuitados(int emprestimosQuitados) {
        this.emprestimosQuitados = emprestimosQuitados;
    }

    public boolean isTemNomeSujo() {
        return temNomeSujo;
    }

    public void setTemNomeSujo(boolean temNomeSujo) {
        this.temNomeSujo = temNomeSujo;
    }

    @Override
    public String toString() {
        return "HistoricoFinanceiro{" +
                "dividas=" + dividas +
                ", emprestimosQuitados=" + emprestimosQuitados +
                ", temNomeSujo=" + temNomeSujo +
                '}';
    }
}
