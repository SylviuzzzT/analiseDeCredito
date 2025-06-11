package com.bank.demo.domain.model;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private CPF cpf;
    private int idade;
    private Renda renda;
    private HistoricoFinanceiro historico;
    int score = 500;

    public Pessoa(String nome, CPF cpf, int idade, Renda renda, HistoricoFinanceiro historico) {

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.renda = renda;
        this.historico = historico;

    }
    public int calculaScore(){

        score += calculaScorePorIdade();
        score += calculaScorePorRenda();
        score += calculaScorePorDivida();

        return score;
    }

    public int calculaScorePorIdade(){
        if(idade > 24 && idade < 60)return 50;
        if (idade < 25) return -25;

        return 0;
    }

    public int calculaScorePorRenda(){
        if (renda.getValor() >= 5000) return 50;

        if(renda.getValor() > 2000) return 25;

        return -50;
    }

    public int calculaScorePorDivida(){
        int qntDividas = historico.getDividas().size();

        if (qntDividas == 0) return 100;
        if(qntDividas < 2) return -25;

        return -50;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
    }

    public HistoricoFinanceiro getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoFinanceiro historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(renda, pessoa.renda) && Objects.equals(historico, pessoa.historico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, idade, renda, historico);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", idade=" + idade +
                ", renda=" + renda +
                ", historico=" + historico +
                '}';
    }
}
