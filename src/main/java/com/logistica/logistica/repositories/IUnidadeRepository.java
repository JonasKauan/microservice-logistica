package com.logistica.logistica.repositories;

import com.logistica.logistica.models.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface IUnidadeRepository extends JpaRepository<Unidade, UUID>{
    
}
