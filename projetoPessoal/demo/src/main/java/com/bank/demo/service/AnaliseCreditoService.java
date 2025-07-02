package com.bank.demo.service;

import com.bank.demo.domain.model.ScoreCalculator;
import com.bank.demo.domain.model.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class AnaliseCreditoService {

    public int calculaScore(Pessoa pessoa){
        return ScoreCalculator.calcular(pessoa);
    }

    public String classificaScore(int score){
        if(score >= 800) return "APROVADO COM EXCELENCIA";
        if(score >= 600) return "APROVADO";
        if(score >= 400) return "EM ANALLISE";
        return "REPROVADO";
    }



}
