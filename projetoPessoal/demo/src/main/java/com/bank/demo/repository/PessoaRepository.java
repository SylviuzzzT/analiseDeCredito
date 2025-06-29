package com.bank.demo.repository;

import com.bank.demo.infrastructure.persistence.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    List<PessoaEntity> findByNome(String nome);
    Optional<PessoaEntity> findByCpf(String cpf);

}
