package com.bank.demo.infrastructure.persistence;


import com.bank.demo.domain.model.ModalidadeRenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendaEmbeddable {

    @Enumerated(EnumType.STRING)
    private ModalidadeRenda modalidade;

    private Double valor;

    private Boolean recorrente;


}
