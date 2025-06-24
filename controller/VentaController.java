package com.matiasalt.bazarmanager.apibazar.controller;


import com.matiasalt.bazarmanager.apibazar.dto.VentaResponseDTO;
import com.matiasalt.bazarmanager.apibazar.model.Producto;
import com.matiasalt.bazarmanager.apibazar.model.Venta;
import com.matiasalt.bazarmanager.apibazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> getVentas(){
        List<Venta> listaProductos = ventaServ.getVentas();

        return listaProductos.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/ventas/{codigo_venta}")
    public ResponseEntity<Venta> getVenta(@PathVariable Long codigo_venta){
        Venta venta = ventaServ.findVenta(codigo_venta);

        return venta != null? ResponseEntity.ok(venta) : null;
    }

    @PostMapping("/ventas/crear")
    public ResponseEntity<Map<String, Object>> createVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);


        List<Long> productosIds = venta.getListaProductos()
                .stream()
                .map(Producto::getId_producto)
                .toList();


        Long clienteId = venta.getUncliente().getId_cliente();


        VentaResponseDTO dtoVenta = new VentaResponseDTO();
        dtoVenta.setFecha_venta(venta.getFecha_venta());
        dtoVenta.setTotal(venta.getTotal());
        dtoVenta.setListaProductos(productosIds);
        dtoVenta.setId_cliente(clienteId);


        Map<String, Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("data", dtoVenta);
        response.put("message", "Venta realizada con éxito");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public ResponseEntity<Map<String, Object>> deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        Map<String, Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("message", "Venta eliminada con exito");

        return ResponseEntity.ok(response);
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public ResponseEntity<Map<String, Object>> editVenta(@PathVariable Long codigo_venta,@RequestBody Venta venta){
        ventaServ.editVenta(codigo_venta, venta);
        Map<String, Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("message", "Venta editada con exito");

        return ResponseEntity.ok(response);
    }

}
