package com.matiasalt.bazarmanager.apibazar.repository;

import com.matiasalt.bazarmanager.apibazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
