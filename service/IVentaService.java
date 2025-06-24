package com.matiasalt.bazarmanager.apibazar.service;

import com.matiasalt.bazarmanager.apibazar.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public void saveVenta(Venta venta);

    public void deleteVenta(Long id);

    public Venta findVenta(Long id);

    public void editVenta(Long id, Venta venta);


}
