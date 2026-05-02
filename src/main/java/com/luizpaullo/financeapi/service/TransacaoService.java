package com.luizpaullo.financeapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luizpaullo.financeapi.enums.TipoTransacao;
import com.luizpaullo.financeapi.model.Transacao;
import com.luizpaullo.financeapi.repository.TransacaoRepository;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    //Criando ou atualizando uma nova transacao
    public Transacao salvar (Transacao transacao) {
        return repository.save(transacao);
    }

    //listando todas transacoes
    public List<Transacao> listar() {
        return repository.findAll();
    }

    public Transacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    //deletar uma transacao
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    //atualizar transacao
    public Transacao atualizar(Long id, Transacao dados) {

        Transacao existente = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        if (dados.getDescricao() != null) {
            existente.setDescricao(dados.getDescricao());
        }

        if (dados.getValor() != null) {
            existente.setValor(dados.getValor());
        }

        if (dados.getTipo() != null) {
            existente.setTipo(dados.getTipo());
        }

        if (dados.getData() != null) {
            existente.setData(dados.getData());
        }

        return repository.save(existente);
    }

    //funcionalidade principal, coração do sistema
    public Double calcularSaldo() {
        List<Transacao> transacoes = repository.findAll();
        double saldo = 0;

        //looping para realizar os calculos
        for (Transacao t : transacoes) {
            if (t.getTipo() == TipoTransacao.RECEITA) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }
}
