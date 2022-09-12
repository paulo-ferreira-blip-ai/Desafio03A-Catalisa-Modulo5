package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Usuarios;
import com.api.gerenciadordecontas.service.ServiceUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class ControllerUsuarios {
    @Autowired
    private ServiceUsuarios serviceUsuarios;

    @GetMapping
    public ResponseEntity< List<Usuarios>> buscarTodos() {
        return ResponseEntity.ok( serviceUsuarios.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity< Optional<Usuarios>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok( serviceUsuarios.buscarId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrar(@RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(serviceUsuarios.cadastrar(usuarios));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity< Usuarios> alterar(@PathVariable Long id, @RequestBody Usuarios usuarios) {
        return ResponseEntity.ok( serviceUsuarios.alterar(usuarios));
    }

    @DeleteMapping(path = "/{id}")
    public String deletar(@PathVariable Long id) {
        serviceUsuarios.deletar(id);
        return "Deletado";
    }
}