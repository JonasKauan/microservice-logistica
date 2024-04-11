package com.logistica.logistica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DestinatarioDTO(
        @NotBlank
        String nomeDestinatario,
        @NotBlank
        String ruaDestinatario,
        @NotBlank String cepDestinatario,
        @NotNull
        Integer numeroDestinatario
) {}
