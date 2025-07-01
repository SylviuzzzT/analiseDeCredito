package com.bank.demo.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class DividaRequest {

    @NotNull(message = "o valor da dívda é obrigtório")
    @DecimalMin(value = "0.0", message = "valor deve ser positivo")
    private Double valor;

    @NotBlank(message = "credor é obrigatório")
    private String credor;

    @NotNull(message = "vencimento é obrigatório")
    private LocalDateTime vencimento;

    private Boolean paga;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }
}
