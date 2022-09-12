package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Cidades;
import com.api.gerenciadordecontas.service.ServiceCidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cidades")
@Validated
public class ControllerCidades {
    @Autowired
    private ServiceCidades serviceCidades;

    @GetMapping
    public ResponseEntity< List<Cidades>> buscarTodos() {
        return ResponseEntity.ok(serviceCidades.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity< Optional<Cidades>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceCidades.buscarId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cidades> cadastrar(@RequestBody Cidades cidades) {
        return ResponseEntity.ok(serviceCidades.cadastrar(cidades));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity< Cidades> alterar(@PathVariable Long id,@RequestBody Cidades cidades) {
        return ResponseEntity.ok(serviceCidades.alterar(cidades));
    }

    @DeleteMapping(path = "/{id}")
    public String deletar(@PathVariable Long id) {
        serviceCidades.deletar(id);
        return "Deletado";
    }
}
