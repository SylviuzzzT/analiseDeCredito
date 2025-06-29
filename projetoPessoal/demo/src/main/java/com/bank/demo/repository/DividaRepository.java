package com.bank.demo.repository;

import com.bank.demo.infrastructure.persistence.DividaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DividaRepository extends JpaRepository<DividaEntity, Integer> {
    List<DividaEntity> findByHistoricoId(Long historicoId);

    List<DividaEntity> findByQuitadaId(boolean quitada);
}
