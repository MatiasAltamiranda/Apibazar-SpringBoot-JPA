package com.matiasalt.bazarmanager.apibazar.service;

import com.matiasalt.bazarmanager.apibazar.model.Producto;
import com.matiasalt.bazarmanager.apibazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
       return productoRepo.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Long id, Producto producto) {
        Producto productoOriginal = this.findProducto(id);

        if(productoOriginal != null){
            if(producto.getCodigo_producto() != null) productoOriginal.setCodigo_producto(producto.getCodigo_producto());
            if(producto.getNombre() != null) productoOriginal.setNombre(producto.getNombre());
            if(producto.getMarca() != null) productoOriginal.setMarca(producto.getMarca());
            if(producto.getPrecio() != null) productoOriginal.setPrecio(producto.getPrecio());
            if(producto.getStock() != null) productoOriginal.setStock(producto.getStock());
        }

        this.saveProducto(productoOriginal);

    }
}
