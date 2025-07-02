package com.bank.demo.infrastructure.mapper;

import com.bank.demo.controller.dto.DividaResponse;
import com.bank.demo.controller.dto.PessoaResponse;
import com.bank.demo.domain.model.ScoreCalculator;
import com.bank.demo.domain.model.Divida;
import com.bank.demo.domain.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaResponseMapper {

    public static PessoaResponse toResponse(Pessoa pessoa) {
        PessoaResponse response = new PessoaResponse();

        response.setNome(pessoa.getNome());
        response.setCpf(pessoa.getCpf().getNumero());
        response.setIdade(pessoa.getIdade());

        response.setRenda(pessoa.getRenda().getValor());
        response.setRendaRecorrente(pessoa.getRenda().isRecorrente());

        response.setEmprestimosQuitados(pessoa.getHistorico().getEmprestimosQuitados());
        response.setNomeSujo(pessoa.getHistorico().isNomeNegativado());

        response.setScore(ScoreCalculator.calcular(pessoa));

        List<DividaResponse> dividas = new ArrayList<>();
        for(Divida divida : pessoa.getHistorico().getDividas()){
            DividaResponse dividaResponse = new DividaResponse(
                    divida.getCredor(),
                    divida.getValor(),
                    divida.getVencimento(),
                    divida.isPaga()
            );
            dividas.add(dividaResponse);
        }

        response.setDividas(dividas);

        return response;

    }

}
