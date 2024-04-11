package com.logistica.logistica.models;

import com.logistica.logistica.enums.TipoZona;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "zona")
@NoArgsConstructor
public class Zona implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idZona;

    private String nomeZona;
    private Double valor;
    private Integer limiteSuperiorCEP;
    private Integer limiteInferiorCEP;
    private TipoZona tipoZona;

    public Zona(int tipoZona){
        setTipoZona(tipoZona);
    }

    @OneToMany(mappedBy = "zona")
    private List<Pacote> pacotes;

    public void setTipoZona(int tipoZona){
        this.tipoZona = TipoZona.valueOf(tipoZona);
    }
}
