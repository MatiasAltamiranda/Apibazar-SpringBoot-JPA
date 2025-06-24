package com.matiasalt.bazarmanager.apibazar.controller;

import com.matiasalt.bazarmanager.apibazar.model.Producto;
import com.matiasalt.bazarmanager.apibazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoServ;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos(){

        List<Producto> listaProductos = productoServ.getProductos();
        return listaProductos.isEmpty()?  ResponseEntity.noContent().build() : ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/productos/{codigo_producto}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long codigo_producto ){
        Producto producto = productoServ.findProducto(codigo_producto);
        if(producto != null) return ResponseEntity.ok(producto);
        return null;
    }

    @PostMapping("/productos/crear")
    public ResponseEntity<Map<String,Object>> createProducto(@RequestBody Producto producto){
        productoServ.saveProducto(producto);

        Map<String,Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("data", producto);
        response.put("message", "Producto creado correctamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public ResponseEntity<Map<String,Object>> deleteProducto (@PathVariable Long codigo_producto){
        productoServ.deleteProducto(codigo_producto);
        Map<String,Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("message", "Producto eliminado correctamente");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public ResponseEntity<Map<String,Object>> editProducto (@PathVariable Long codigo_producto,@RequestBody Producto producto){
        productoServ.editProducto(codigo_producto,producto);
        Map<String,Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("message", "Producto editado correctamente");
        return ResponseEntity.ok(response);
    }

}
