package com.bank.demo.domain.model;

import java.util.List;

public class HistoricoFinanceiro {

    private List<Divida> dividas;
    private int emprestimosQuitados;
    private boolean nomeNegativado;

    public HistoricoFinanceiro(List<Divida> dividas, int emprestimosQuitados, boolean nomeNegativado) {
        this.dividas = dividas;
        this.emprestimosQuitados = emprestimosQuitados;
        this.nomeNegativado = nomeNegativado;
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

    public boolean isNomeNegativado() {
        return nomeNegativado;
    }

    public void setNomeNegativado(boolean nomeNegativado) {
        this.nomeNegativado = nomeNegativado;
    }

    @Override
    public String toString() {
        return "HistoricoFinanceiro{" +
                "dividas=" + dividas +
                ", emprestimosQuitados=" + emprestimosQuitados +
                ", temNomeSujo=" + nomeNegativado +
                '}';
    }
}
