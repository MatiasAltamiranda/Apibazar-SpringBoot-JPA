package com.matiasalt.bazarmanager.apibazar.service;

import com.matiasalt.bazarmanager.apibazar.model.Cliente;
import com.matiasalt.bazarmanager.apibazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Long id, Cliente nuevoCliente) {
        Cliente clienteOriginal = this.findCliente(id);

        if(clienteOriginal !=null){
            if(nuevoCliente.getNombre_cliente() != null) clienteOriginal.setNombre_cliente(nuevoCliente.getNombre_cliente());
            if(nuevoCliente.getApellido_cliente() != null) clienteOriginal.setApellido_cliente(nuevoCliente.getApellido_cliente());
            if(nuevoCliente.getDni_cliente() != null) clienteOriginal.setDni_cliente(nuevoCliente.getDni_cliente());
        }

        this.saveCliente(clienteOriginal);

    }


}
