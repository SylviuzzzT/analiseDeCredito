package com.bank.demo.controller;

import com.bank.demo.controller.dto.AnaliseCreditoResponse;
import com.bank.demo.controller.dto.PessoaRequest;
import com.bank.demo.controller.dto.PessoaResponse;
import com.bank.demo.domain.model.Pessoa;
import com.bank.demo.infrastructure.mapper.PessoaRequestMapper;
import com.bank.demo.infrastructure.mapper.PessoaResponseMapper;
import com.bank.demo.service.AnaliseCreditoService;
import com.bank.demo.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class PessoaController {

    private PessoaService pessoaService;
    private AnaliseCreditoService analiseCreditoService;

    public PessoaController(PessoaService pessoaService, AnaliseCreditoService analiseCreditoService) {
        this.pessoaService = pessoaService;
        this.analiseCreditoService = analiseCreditoService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody @Valid PessoaRequest request){
        Pessoa pessoa = PessoaRequestMapper.toDomain(request);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        PessoaResponse response = PessoaResponseMapper.toResponse(pessoaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PessoaResponse>> buscarPorNome(@PathVariable String nome){
        List<Pessoa> pessoas = pessoaService.buscarPorNome(nome);
        List<PessoaResponse> responses = new ArrayList<>();

        for (Pessoa pessoa : pessoas){
            responses.add(PessoaResponseMapper.toResponse(pessoa));
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listarTodos(){
        List<Pessoa> pessoas = pessoaService.listarTodos();
        List<PessoaResponse> responses = new ArrayList<>();

        for(Pessoa pessoa : pessoas){
            responses.add(PessoaResponseMapper.toResponse(pessoa));
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaResponse> buscarPorCpf(@PathVariable String cpf){
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf);
        PessoaResponse response =  PessoaResponseMapper.toResponse(pessoa);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<PessoaResponse> atualizar(@RequestBody PessoaRequest request){
        Pessoa pessoa = PessoaRequestMapper.toDomain(request);
        Pessoa pessoaAtualizada = pessoaService.atualizar(pessoa);
        PessoaResponse response = PessoaResponseMapper.toResponse(pessoaAtualizada);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> remover(@PathVariable String cpf){
        pessoaService.removerPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}/analise-credito")
    public ResponseEntity<AnaliseCreditoResponse> analisarCredito(@PathVariable String cpf){
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf);
        int score = analiseCreditoService.calculaScore(pessoa);
        String resultado = analiseCreditoService.classificaScore(score);

        AnaliseCreditoResponse response = new AnaliseCreditoResponse(
                pessoa.getCpf().getNumero(),
                pessoa.getNome(),
                score,
                resultado

        );
        return ResponseEntity.ok(response);
    }



}
