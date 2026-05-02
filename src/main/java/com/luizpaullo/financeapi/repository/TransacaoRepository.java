package com.luizpaullo.financeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizpaullo.financeapi.model.Transacao;

public interface TransacaoRepository extends JpaRepository <Transacao, Long>{

}
