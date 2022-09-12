package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Enderecos;
import com.api.gerenciadordecontas.model.Usuarios;
import com.api.gerenciadordecontas.service.ServiceEnderecos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enderecos")
public class ControllerEnderecos {
    @Autowired
    private ServiceEnderecos serviceEnderecos;

    @GetMapping
    public ResponseEntity< List<Enderecos>> buscarTodos() {
        return ResponseEntity.ok(serviceEnderecos.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Enderecos>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceEnderecos.buscarId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity< Enderecos> cadastrar(@RequestBody Enderecos enderecos) {
        return ResponseEntity.ok(serviceEnderecos.cadastrar(enderecos));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity< Enderecos> alterar(@PathVariable Long id, @RequestBody Enderecos enderecos) {
        return ResponseEntity.ok(serviceEnderecos.alterar(enderecos));
    }

    @DeleteMapping(path = "/{id}")
    public String deletarEndereco(@PathVariable Long id) {
        serviceEnderecos.deletar(id);
        return "Deletado";
    }
}
