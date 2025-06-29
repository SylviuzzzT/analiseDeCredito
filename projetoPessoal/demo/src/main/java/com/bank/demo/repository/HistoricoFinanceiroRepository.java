package com.bank.demo.repository;

import com.bank.demo.infrastructure.persistence.HistoricoFinanceiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoFinanceiroRepository extends JpaRepository<HistoricoFinanceiroEntity, Long> {



}
