package com.bank.demo.controller.dto;

import com.bank.demo.domain.model.HistoricoFinanceiro;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaRequest {

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull
    @Min(value = 18, message = "idade não pode ser menor que 18")
    private Integer idade;

    @NotNull(message = "Dados de renda são obrigatórios")
    private RendaRequest renda;

    @NotNull(message = "historico financeiro é obrigatório")
    private HistoricoFinanceiroRequest historicoFinanceiro;

    public PessoaRequest(String nome, String cpf, Integer idade, RendaRequest renda, HistoricoFinanceiroRequest historicoFinanceiro) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.renda = renda;
        this.historicoFinanceiro = historicoFinanceiro;
    }

    public PessoaRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public RendaRequest getRenda() {
        return renda;
    }

    public void setRenda(RendaRequest renda) {
        this.renda = renda;
    }

    public HistoricoFinanceiroRequest getHistoricoFinanceiro() {
        return historicoFinanceiro;
    }

    public void setHistoricoFinanceiro(HistoricoFinanceiroRequest historicoFinanceiro) {
        this.historicoFinanceiro = historicoFinanceiro;
    }
}
