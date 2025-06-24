package com.matiasalt.bazarmanager.apibazar.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany
    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    private Cliente uncliente;

    public Venta() {
    }

    public Venta(Long id_venta, Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente uncliente) {
        this.id_venta = id_venta;
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.uncliente = uncliente;
    }
}
