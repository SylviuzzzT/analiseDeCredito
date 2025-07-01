package com.bank.demo.infrastructure.mapper;

import com.bank.demo.controller.dto.DividaRequest;
import com.bank.demo.controller.dto.PessoaRequest;
import com.bank.demo.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class PessoaRequestMapper {

    public static Pessoa toDomain(PessoaRequest request){

        //mapeando renda
        Renda renda = new Renda(
                ModalidadeRenda.valueOf(request.getRenda().getModalidade().toString().toUpperCase()),
                request.getRenda().getValor(),
                request.getRenda().getRecorrente()

        );

        //mapeia as dividas
        List<Divida> dividas = new ArrayList<>();
        for(DividaRequest divida : request.getHistoricoFinanceiro().getDividas()){
            Divida dividaDomain = new Divida(
                    divida.getValor(),
                    divida.getCredor(),
                    divida.getVencimento(),
                    divida.getPaga()
            );
            dividas.add(dividaDomain);
        }

        //mapeia historico financeiro
        HistoricoFinanceiro historicoFinanceiro = new HistoricoFinanceiro(
                dividas,
                request.getHistoricoFinanceiro().getEmprestimosQuitados(),
                request.getHistoricoFinanceiro().isNomeSujo()
        );

        Pessoa pessoa = new Pessoa(
                request.getNome(),
                new CPF(request.getCpf()),
                request.getIdade(),
                renda,
                historicoFinanceiro
        );

        return pessoa;

    }

}
