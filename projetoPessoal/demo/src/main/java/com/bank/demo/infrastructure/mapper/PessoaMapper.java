package com.bank.demo.infrastructure.mapper;

import com.bank.demo.domain.model.CPF;
import com.bank.demo.domain.model.HistoricoFinanceiro;
import com.bank.demo.domain.model.Pessoa;
import com.bank.demo.domain.model.Renda;
import com.bank.demo.infrastructure.persistence.DividaEntity;
import com.bank.demo.infrastructure.persistence.PessoaEntity;
import com.bank.demo.infrastructure.persistence.RendaEmbeddable;

public class PessoaMapper {

    public static Pessoa toDomain(PessoaEntity pessoaEntity) {
        return new Pessoa(
                pessoaEntity.getNome(),
                new CPF(pessoaEntity.getCpf()),
                pessoaEntity.getIdade(),
                new Renda(
                        pessoaEntity.getRenda().getModalidade(),
                        pessoaEntity.getRenda().getValor(),
                        pessoaEntity.getRenda().getRecorrente()
                ),
                HistoricoFinanceiroMapper.toDomain(pessoaEntity.getHistorico())
                );

    }

    public static PessoaEntity toEntity(Pessoa pessoa){
            PessoaEntity pessoaEntity = new PessoaEntity();

            pessoaEntity.setNome(pessoa.getNome());
            pessoaEntity.setCpf(pessoa.getCpf().getNumero());
            pessoaEntity.setIdade(pessoa.getIdade());
            pessoaEntity.setRenda(new RendaEmbeddable(
                    pessoa.getRenda().getModalidade(),
                    pessoa.getRenda().getValor(),
                    pessoa.getRenda().isRecorrente()
                    ));

            pessoaEntity.setHistorico(HistoricoFinanceiroMapper.toEntity(pessoa.getHistorico()));

            return pessoaEntity;


    }


}


