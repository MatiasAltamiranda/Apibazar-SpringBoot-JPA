package com.matiasalt.bazarmanager.apibazar.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String dni_cliente;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre_cliente, String apellido_cliente, String dni_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.dni_cliente = dni_cliente;
    }
}
