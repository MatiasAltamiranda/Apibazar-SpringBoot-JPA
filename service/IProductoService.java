package com.matiasalt.bazarmanager.apibazar.service;

import com.matiasalt.bazarmanager.apibazar.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public void deleteProducto (Long id);

    public Producto findProducto(Long id);

    public void editProducto(Long id, Producto producto);



}
