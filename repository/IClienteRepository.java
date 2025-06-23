package com.matiasalt.bazarmanager.apibazar.repository;

import com.matiasalt.bazarmanager.apibazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long> {
}
