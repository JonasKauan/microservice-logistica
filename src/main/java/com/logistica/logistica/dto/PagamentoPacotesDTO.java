package com.logistica.logistica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record PagamentoPacotesDTO(
    @NotNull
    UUID fkFuncionario,

    @Positive
    int idTipoPagamento,

    @Positive
    int id
) {}
