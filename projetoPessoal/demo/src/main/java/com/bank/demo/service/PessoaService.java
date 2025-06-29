package com.bank.demo.service;

import com.bank.demo.domain.model.Pessoa;
import com.bank.demo.infrastructure.mapper.PessoaMapper;
import com.bank.demo.infrastructure.persistence.PessoaEntity;
import com.bank.demo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PessoaService  {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //salvar pessoa
    public Pessoa salvar(Pessoa pessoa){
        PessoaEntity pessoaEntity = PessoaMapper.toEntity(pessoa);
        PessoaEntity pessoaSalva = pessoaRepository.save(pessoaEntity);

        return PessoaMapper.toDomain(pessoaSalva);
    }

    //alterar pessoa
    public Pessoa atualizar(Pessoa pessoa){
        PessoaEntity pessoaEntity = PessoaMapper.toEntity(pessoa);
        PessoaEntity pessoaSalva = pessoaRepository.save(pessoaEntity);

        return PessoaMapper.toDomain(pessoaSalva);

    }



    //remove uma pessoa por cpf
    public void removerPorCpf(String cpf){

        PessoaEntity pessoaEntity = pessoaRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário com cpf "+ cpf +" não encontrado"));

        pessoaRepository.delete(pessoaEntity);

    }


    //busca pessoa por cpf
    public Pessoa buscarPorCpf(String cpf){
        PessoaEntity pessoaEntity = pessoaRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário com cpf "+ cpf +" não encontrado"));

        return PessoaMapper.toDomain(pessoaEntity);
    }


    //busca e lista pessoas por nome
    public List<Pessoa> buscarPorNome(String nome){
        List<PessoaEntity> pessoaEntity = pessoaRepository.findByNome(nome);
        if (pessoaEntity.isEmpty()){
            throw new RuntimeException("Nenhum usuário com nome "+ nome + " foi encontrado");
        }
        List<Pessoa> pessoas = new ArrayList<>();
        for(PessoaEntity entity : pessoaEntity ){
            pessoas.add(PessoaMapper.toDomain(entity));
        }

        return pessoas;
    }

    //listar todas as pessoas
    public List<Pessoa> listarTodos(){
        List<PessoaEntity> pessoaEntity = pessoaRepository.findAll();
        List<Pessoa> pessoas = new ArrayList<>();
        for(PessoaEntity entity : pessoaEntity ){
            pessoas.add(PessoaMapper.toDomain(entity));
        }
        return pessoas;

    }

}
