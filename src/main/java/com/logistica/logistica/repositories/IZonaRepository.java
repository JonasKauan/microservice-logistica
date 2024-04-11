package com.logistica.logistica.repositories;

import com.logistica.logistica.models.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IZonaRepository extends JpaRepository<Zona, UUID> {

    @Query("SELECT z FROM Zona z WHERE z.limiteInferiorCEP <= ?1 AND z.limiteSuperiorCEP >= ?1")
    Zona findByCep(Integer cep);
}
