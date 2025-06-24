package com.matiasalt.bazarmanager.apibazar.dto;


import com.matiasalt.bazarmanager.apibazar.model.Cliente;
import com.matiasalt.bazarmanager.apibazar.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class VentaResponseDTO {
    private LocalDate fecha_venta;
    private Double total;
    private List<Long> listaProductos;
    private Long  id_cliente;


}
