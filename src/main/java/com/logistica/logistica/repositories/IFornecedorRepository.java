package com.logistica.logistica.repositories;

import com.logistica.logistica.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFornecedorRepository extends JpaRepository<Fornecedor, UUID>{
    
}
