package com.logistica.logistica.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFornecedor;
    private String nomeFornecedor;
    private String cnpjMatriz;

    @OneToMany(mappedBy = "fornecedor")
    private List<Unidade> unidades;
}
