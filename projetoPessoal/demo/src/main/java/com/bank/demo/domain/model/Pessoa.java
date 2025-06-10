package com.bank.demo.domain.model;

import java.util.List;

public class Pessoa {

    private String nome;
    private CPF cpf;
    private int idade;
    private Renda renda;
    private HistoricoFinanceiro historico;

    public Pessoa(String nome, CPF cpf, int idade, Renda renda, HistoricoFinanceiro historico) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.renda = renda;
        this.historico = historico;
    }
}
