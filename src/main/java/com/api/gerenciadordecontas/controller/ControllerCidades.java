package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Cidades;
import com.api.gerenciadordecontas.service.ServiceCidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cidades")
@Validated
public class ControllerCidades {
    @Autowired
    private ServiceCidades serviceCidades;

    @GetMapping
    public ResponseEntity<List<Cidades>> buscarTodos() {
        return ResponseEntity.ok(serviceCidades.buscarTodos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<Cidades>> buscarPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(serviceCidades.buscarId(codigo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cidades> cadastrar(@Valid @RequestBody Cidades cidades) {
        return ResponseEntity.ok(serviceCidades.cadastrar(cidades));
    }

    @PatchMapping(path = "/{codigo}")
    public ResponseEntity<Cidades> alterar(@Valid @PathVariable Long codigo, @RequestBody Cidades cidades) {
        return ResponseEntity.ok(serviceCidades.alterar(cidades, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletar(@PathVariable Long codigo) {
        serviceCidades.deletar(codigo);
        return "Deletado";
    }
}
