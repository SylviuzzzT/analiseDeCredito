package com.bank.demo.controller;

import com.bank.demo.controller.dto.PessoaRequest;
import com.bank.demo.controller.dto.PessoaResponse;
import com.bank.demo.domain.model.Pessoa;
import com.bank.demo.infrastructure.mapper.PessoaRequestMapper;
import com.bank.demo.infrastructure.mapper.PessoaResponseMapper;
import com.bank.demo.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody @Valid PessoaRequest request){
        Pessoa pessoa = PessoaRequestMapper.toDomain(request);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        PessoaResponse response = PessoaResponseMapper.toResponse(pessoaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pessoa>> buscarPorNome(@PathVariable String nome){
        pessoaService.buscarPorNome(nome);
        return ResponseEntity.ok(pessoaService.buscarPorNome(nome));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodos(){
        return ResponseEntity.ok(pessoaService.listarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf){
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa){
        Pessoa pessoaAtualizada = pessoaService.atualizar(pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> remover(@PathVariable String cpf){
        pessoaService.removerPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }



}
