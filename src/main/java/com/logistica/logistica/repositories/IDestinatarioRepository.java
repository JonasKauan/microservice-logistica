package com.logistica.logistica.repositories;

import com.logistica.logistica.models.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDestinatarioRepository extends JpaRepository<Destinatario, UUID>{
    
}
