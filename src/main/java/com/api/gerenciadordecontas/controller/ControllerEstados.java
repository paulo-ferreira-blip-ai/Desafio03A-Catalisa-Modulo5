package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Estados;
import com.api.gerenciadordecontas.service.ServiceEstados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estados")
@Validated
public class ControllerEstados {
    @Autowired
    private ServiceEstados serviceEstados;

    @GetMapping
    public ResponseEntity<List<Estados>> buscarTodos() {
        return ResponseEntity.ok(serviceEstados.buscarTodos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<Estados>> buscarPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(serviceEstados.buscarId(codigo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estados> cadastrar(@Valid @RequestBody Estados estados) {
        return ResponseEntity.ok(serviceEstados.cadastrar(estados));
    }

    @PatchMapping(path = "/{codigo}")
    public ResponseEntity<Estados> alterar(@PathVariable Long codigo, @RequestBody Estados estados) {
        return ResponseEntity.ok(serviceEstados.alterar(estados, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletar(@PathVariable Long codigo) {
        serviceEstados.deletar(codigo);
        return "Deletado";
    }
}
