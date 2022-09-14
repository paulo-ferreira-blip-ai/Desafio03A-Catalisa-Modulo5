package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.Enderecos;
import com.api.gerenciadordecontas.service.ServiceEnderecos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enderecos")
public class ControllerEnderecos {
    @Autowired
    private ServiceEnderecos serviceEnderecos;

    @GetMapping
    public ResponseEntity<List<Enderecos>> buscarTodos() {
        return ResponseEntity.ok(serviceEnderecos.buscarTodos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<Enderecos>> buscarPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(serviceEnderecos.buscarId(codigo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Enderecos> cadastrar(@Valid @RequestBody Enderecos enderecos) {
        return ResponseEntity.ok(serviceEnderecos.cadastrar(enderecos));
    }

    @PatchMapping(path = "/{codigo}")
    public ResponseEntity<Enderecos> alterar(@PathVariable Long codigo, @RequestBody Enderecos enderecos) {
        return ResponseEntity.ok(serviceEnderecos.alterar(enderecos, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletarEndereco(@PathVariable Long codigo) {
        serviceEnderecos.deletar(codigo);
        return "Deletado";
    }
}
