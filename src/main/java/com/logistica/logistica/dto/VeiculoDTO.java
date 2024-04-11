package com.logistica.logistica.dto;

import jakarta.validation.constraints.NotBlank;

public record VeiculoDTO(
         @NotBlank String tipoVeiculo,
         @NotBlank String proprietario,
         @NotBlank String placa
) {}
