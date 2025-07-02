package com.bank.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnaliseCreditoResponse {
    private String cpf;
    private String nome;
    private int score;
    private String resultado;


}
