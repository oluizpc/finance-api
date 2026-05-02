package com.luizpaullo.financeapi.model;
import java.time.LocalDate;

import com.luizpaullo.financeapi.enums.TipoTransacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valor;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    private LocalDate data;
}