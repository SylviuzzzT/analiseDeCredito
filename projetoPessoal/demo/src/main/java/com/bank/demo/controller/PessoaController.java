package com.bank.demo.controller;

import com.bank.demo.domain.model.Pessoa;
import com.bank.demo.service.PessoaService;
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
    public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pessoa>> buscarPorNome(@PathVariable String nome){
        pessoaService.buscarPorNome(nome);
        return ResponseEntity.ok(pessoaService.buscarPorNome(nome));
    }
    @GetMapping
    public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf){
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable String cpf){
        pessoaService.removerPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }



}
