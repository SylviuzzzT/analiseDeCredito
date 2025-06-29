package com.bank.demo.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "divida")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DividaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private String credor;

    private LocalDateTime vencimento;

    private boolean quitada;

    @ManyToOne
    @JoinColumn(name = "historico_id")
    private HistoricoFinanceiroEntity historico;


}
