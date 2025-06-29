package com.bank.demo.infrastructure.mapper;

import com.bank.demo.domain.model.Divida;
import com.bank.demo.infrastructure.persistence.DividaEntity;
import com.bank.demo.infrastructure.persistence.HistoricoFinanceiroEntity;

public class DividaMapper {
    public static Divida toDomain(DividaEntity entity) {
        return new Divida(
                entity.getValor(),
                entity.getCredor(),
                entity.getVencimento(),
                entity.isQuitada()
        );
    }

    public static DividaEntity toEntity(Divida domain, HistoricoFinanceiroEntity historicoFinanceiro) {
        return new DividaEntity(
                null,
                domain.getValor(),
                domain.getCredor(),
                domain.getVencimento(),
                domain.isPaga(),
                historicoFinanceiro
        );
    }

}
