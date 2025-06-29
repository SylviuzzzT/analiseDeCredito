package com.bank.demo.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historico_financeiro")
public class HistoricoFinanceiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "historico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DividaEntity> dividas;

    private Integer emprestimosQuitados;

    private boolean nomeSujo;

}
