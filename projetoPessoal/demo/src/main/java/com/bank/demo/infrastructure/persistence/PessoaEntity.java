package com.bank.demo.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;


    private String cpf;


    private Integer idade;

    @Embedded
    private RendaEmbeddable renda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historico_id", referencedColumnName = "id")
    private HistoricoFinanceiroEntity historico;
}
