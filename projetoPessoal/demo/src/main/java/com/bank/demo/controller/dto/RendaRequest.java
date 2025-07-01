package com.bank.demo.controller.dto;

import com.bank.demo.domain.model.ModalidadeRenda;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RendaRequest {

    @NotNull(message = "modalidade é obrigatório")
    private ModalidadeRenda modalidade;

    @DecimalMin(value = "0.0", inclusive = false, message = "renda deve positiva")
    private Double valor;

    private Boolean recorrente;

    public ModalidadeRenda getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeRenda modalidade) {
        this.modalidade = modalidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getRecorrente() {
        return recorrente;
    }

    public void setRecorrente(Boolean recorrente) {
        this.recorrente = recorrente;
    }
}
