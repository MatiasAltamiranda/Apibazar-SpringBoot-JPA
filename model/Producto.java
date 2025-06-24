package com.matiasalt.bazarmanager.apibazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double precio;
    private Double stock;

    public Producto() {
    }

    public Producto(Long id_producto, Long codigo_producto, String nombre, String marca, Double precio, Double stock) {
        this.id_producto = id_producto;
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }
}
