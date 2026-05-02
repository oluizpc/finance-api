package com.luizpaullo.financeapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizpaullo.financeapi.model.Transacao;
import com.luizpaullo.financeapi.service.TransacaoService;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public Transacao salvar (@RequestBody Transacao transacao) {
        return service.salvar(transacao);
    }

    @GetMapping
    public List<Transacao> listar() {
        return service.listar();
    }

    @GetMapping("/saldo")
    public Double calcularSaldo() {
        return service.calcularSaldo();
    }

    //1. Buscar por ID
    //GET /api/transacoes/{id}
    //retorna uma transação específica

    @GetMapping("/{id}")
    public Transacao buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    //2. Deletar
    //DELETE /api/transacoes/{id}
    //remove uma transação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable("id") Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //3. Atualizar
    //PUT /api/transacoes/{id}
    @PutMapping("/{id}")
    public Transacao atualizar(@PathVariable("id") Long id, @RequestBody Transacao transacao) {
        return service.atualizar(id, transacao);
    }   
}