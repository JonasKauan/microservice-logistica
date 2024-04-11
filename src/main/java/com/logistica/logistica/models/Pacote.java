package com.logistica.logistica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logistica.logistica.enums.StatusPacote;
import com.logistica.logistica.enums.TipoPacote;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pacote")
public class Pacote implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPacote;

    private int tipo;

    private int status;

    private boolean pagamentoFeito;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_zona")
    private Zona zona;

    private UUID fkFuncionario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_destinatario")
    private Destinatario destinatario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_unidade")
    private Unidade unidade;

    public StatusPacote getStatus(){
        return StatusPacote.valueOf(this.status);
    }

    public TipoPacote getTipo(){
        return TipoPacote.valueOf(this.tipo);
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "idPacote=" + idPacote +
                ", tipo=" + tipo +
                ", status=" + status +
                ", zona=" + zona +
                ", colaborador=" + fkFuncionario +
                ", destinatario=" + destinatario +
                ", unidade=" + unidade +
                '}';
    }
}
