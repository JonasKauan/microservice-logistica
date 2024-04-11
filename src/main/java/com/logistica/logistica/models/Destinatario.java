package com.logistica.logistica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "destinatario")
public class Destinatario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDestinatario;

    private String nomeDestinatario;
    private String ruaDestinatario;
    private String cepDestinatario;
    private Integer numeroDestinatario;

    @JsonIgnore
    @OneToMany(mappedBy = "destinatario")
    private List<Pacote> pacotes;
}
