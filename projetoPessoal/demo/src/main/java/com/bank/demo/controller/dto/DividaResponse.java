package com.bank.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DividaResponse {
    private String credor;
    private double valor;
    private LocalDateTime vencimento;
    private boolean paga;

}
