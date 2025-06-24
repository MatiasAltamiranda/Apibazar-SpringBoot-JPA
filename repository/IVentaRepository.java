package com.matiasalt.bazarmanager.apibazar.repository;

import com.matiasalt.bazarmanager.apibazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
}
