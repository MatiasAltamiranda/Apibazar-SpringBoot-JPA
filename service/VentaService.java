package com.matiasalt.bazarmanager.apibazar.service;


import com.matiasalt.bazarmanager.apibazar.model.Venta;
import com.matiasalt.bazarmanager.apibazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Long id, Venta venta) {
        Venta ventaOriginal = this.findVenta(id);

        if(ventaOriginal!=null){
            if(venta.getCodigo_venta() != null) ventaOriginal.setCodigo_venta(venta.getCodigo_venta());
            if(venta.getFecha_venta() != null) ventaOriginal.setFecha_venta(venta.getFecha_venta());
            if(venta.getTotal() != null) ventaOriginal.setTotal(venta.getTotal());
            if(venta.getListaProductos() != null) ventaOriginal.setListaProductos(venta.getListaProductos());
            if(venta.getUncliente() != null) ventaOriginal.setUncliente(venta.getUncliente());
        }

        this.saveVenta(ventaOriginal);
    }
}
