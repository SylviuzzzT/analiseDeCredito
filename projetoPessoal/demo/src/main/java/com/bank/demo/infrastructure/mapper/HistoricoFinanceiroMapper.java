package com.bank.demo.infrastructure.mapper;

import com.bank.demo.domain.model.Divida;
import com.bank.demo.domain.model.HistoricoFinanceiro;
import com.bank.demo.infrastructure.persistence.DividaEntity;
import com.bank.demo.infrastructure.persistence.HistoricoFinanceiroEntity;

import java.util.ArrayList;
import java.util.List;

public class HistoricoFinanceiroMapper {

    public static HistoricoFinanceiro toDomain(HistoricoFinanceiroEntity historicoFinanceiroEntity) {
        List<Divida> dividas = new ArrayList<>();
        for (DividaEntity dividaEntity : historicoFinanceiroEntity.getDividas()) {
            dividas.add(DividaMapper.toDomain(dividaEntity));
        }
        return new HistoricoFinanceiro(
                dividas,
                historicoFinanceiroEntity.getEmprestimosQuitados(),
                historicoFinanceiroEntity.isNomeSujo()

        );

    }

    public static HistoricoFinanceiroEntity toEntity(HistoricoFinanceiro historicoFinanceiro) {
        HistoricoFinanceiroEntity historicoFinanceiroEntity = new HistoricoFinanceiroEntity();

        historicoFinanceiroEntity.setEmprestimosQuitados(historicoFinanceiro.getEmprestimosQuitados());
        historicoFinanceiroEntity.setNomeSujo(historicoFinanceiro.isTemNomeSujo());

        List<DividaEntity> dividas = new ArrayList<>();
        for(Divida divida : historicoFinanceiro.getDividas()){
            dividas.add(DividaMapper.toEntity(divida, historicoFinanceiroEntity));
        }

        historicoFinanceiroEntity.setDividas(dividas);

        return historicoFinanceiroEntity;
    }



}
