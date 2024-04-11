package com.logistica.logistica.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record FornecedorDTO(
        @NotBlank String nomeFornecedor,
        @NotBlank
        @CNPJ
        String cnpjMatriz
){}
