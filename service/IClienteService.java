package com.matiasalt.bazarmanager.apibazar.service;

import com.matiasalt.bazarmanager.apibazar.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente(Cliente cliente);

    public void deleteCliente(Long id);

    public Cliente findCliente(Long id);

    public void editCliente(Long id, Cliente nuevoCliente);

}
