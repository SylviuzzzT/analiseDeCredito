package com.bank.demo.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class HistoricoFinanceiroRequest {

    @NotNull(message = "a lista de dívidas não pode ser null ")
    private List<DividaRequest> dividas;

    private int emprestimosQuitados;

    private boolean nomeSujo;

    public List<DividaRequest> getDividas() {
        return dividas;
    }

    public void setDividas(List<DividaRequest> dividas) {
        this.dividas = dividas;
    }

    public int getEmprestimosQuitados() {
        return emprestimosQuitados;
    }

    public void setEmprestimosQuitados(int emprestimosQuitados) {
        this.emprestimosQuitados = emprestimosQuitados;
    }

    public boolean isNomeSujo() {
        return nomeSujo;
    }

    public void setNomeSujo(boolean nomeSujo) {
        this.nomeSujo = nomeSujo;
    }
}
