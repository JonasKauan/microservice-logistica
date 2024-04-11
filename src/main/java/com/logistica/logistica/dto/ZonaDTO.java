package com.logistica.logistica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ZonaDTO(
        @NotBlank
        String nomeZona,
        @NotNull
        Double valor,
        @NotNull
        Integer limiteSuperiorCEP,
        @NotNull
        Integer limiteInferiorCEP,
        @Positive
        int tipoZona
) {}