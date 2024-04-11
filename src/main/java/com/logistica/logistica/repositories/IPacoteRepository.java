package com.logistica.logistica.repositories;

import com.logistica.logistica.models.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IPacoteRepository extends JpaRepository<Pacote, UUID> {

    @Query("SELECT p FROM Pacote p WHERE p.fkFuncionario = ?1 AND p.status = 3 AND pagamentoFeito = false")
    List<Pacote> findPackagesForPayment(UUID fkFuncionario);
}
