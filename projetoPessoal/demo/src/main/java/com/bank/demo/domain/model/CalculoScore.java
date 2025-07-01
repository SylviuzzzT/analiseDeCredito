package com.bank.demo.domain.model;

import java.util.List;

public class CalculoScore {

    private Pessoa pessoa;

    public static int calcular(Pessoa pessoa) {
        int score = 500;

        score += calculaScorePorIdade(pessoa.getIdade());
        score += calculaScorePorRenda(pessoa.getRenda().getValor());
        score += calculaScorePorDivida(pessoa.getHistorico().getDividas().size());
        score += calculaScorePorComprometimento(pessoa.getHistorico().getDividas(), pessoa.getRenda().getValor());

        return score;
    }

    public static int calculaScorePorIdade(int idade) {
        if(idade > 24 && idade < 60)return 50;
        if (idade < 25) return -25;

        return 0;
    }

    public static int calculaScorePorRenda(double valorRenda){
        if (valorRenda >= 5000) return 50;

        if(valorRenda > 2000) return 25;

        return -50;
    }

    public static int calculaScorePorDivida(int quantidadeDividas) {

        if (quantidadeDividas == 0) return 100;
        if(quantidadeDividas < 2) return -25;

        return -50;

    }

    public static int calculaScorePorComprometimento(List<Divida> dividas, double renda) {
        double totalDividas = 0;
        double comprometimento = 0;

        if (dividas.isEmpty()){
            return 50;
        }

        for (Divida divida : dividas){
            if (!divida.isPaga()){
                totalDividas += divida.getValor();

            }
        }
        comprometimento += totalDividas/renda;
        if (comprometimento < 0.2){
            return 50;
        }else if (comprometimento < 0.5){
            return 25;
        }else if(comprometimento < 0.8){
            return 0;
        }else {
            return -50;
        }


    }
}
