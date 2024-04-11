package com.logistica.logistica.repositories;


import com.logistica.logistica.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IVeiculoRepository extends JpaRepository<Veiculo, UUID> {
}
