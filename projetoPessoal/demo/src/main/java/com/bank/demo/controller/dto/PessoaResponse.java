package com.bank.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaResponse {

    private String nome;
    private String cpf;
    private Integer idade;
    private double renda;
    private boolean rendaRecorrente;
    private int emprestimosQuitados;
    private boolean nomeSujo;
    private int score;
    private List<DividaResponse> dividas;


}
