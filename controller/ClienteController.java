package com.matiasalt.bazarmanager.apibazar.controller;

import com.matiasalt.bazarmanager.apibazar.model.Cliente;
import com.matiasalt.bazarmanager.apibazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;


    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> listaClientes = clienteServ.getClientes();

        if (listaClientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listaClientes);
        }
    }

    @GetMapping("/clientes/{id_cliente}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id_cliente) {
       Cliente cliente = clienteServ.findCliente(id_cliente);

        if (cliente != null) return ResponseEntity.ok(cliente);

        return null;
    }


    @PostMapping("/clientes/crear")
    public ResponseEntity<Map<String, Object>> createCliente(@RequestBody Cliente cliente) {
        clienteServ.saveCliente(cliente);

        Map<String, Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("data", cliente);
        response.put("message", "Cliente creado correctamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("clientes/eliminar/{id_cliente}")
    public ResponseEntity<Map<String, Object>> deleteCliente(@PathVariable Long id_cliente){
        clienteServ.deleteCliente(id_cliente);
        Map<String, Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("message", "Cliente eliminado correctamente");

        return ResponseEntity.ok(response);
    }


    @PutMapping("clientes/editar/{id_cliente}")
    public ResponseEntity<Map<String,Object>> editCliente(@PathVariable Long id_cliente,@RequestBody Cliente cliente){
        clienteServ.editCliente(id_cliente, cliente);
        Map<String, Object> response = new HashMap<>();
        response.put("ok", true);
        response.put("message", "Cliente actualizado correctamente");
        return ResponseEntity.ok(response);
    }

}
