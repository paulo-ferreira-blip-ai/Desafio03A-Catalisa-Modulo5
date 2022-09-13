package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.enums.TipoRecebimento;
import com.api.gerenciadordecontas.model.ContasAReceber;
import com.api.gerenciadordecontas.service.ServiceContasAReceber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contasAReceber")
@Validated
public class ControllerContasAReceber {
    @Autowired
    private ServiceContasAReceber serviceContasAReceber;

    @GetMapping
    public ResponseEntity<List<ContasAReceber>> buscarTodos() {
        return ResponseEntity.ok(serviceContasAReceber.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ContasAReceber>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceContasAReceber.buscarId(id));
    }

    @GetMapping(path = "/recebimento/{tipoRecebimento}")
    public ResponseEntity<List<ContasAReceber>> findByTipoRecebimento(@PathVariable TipoRecebimento tipoRecebimento) {
        return ResponseEntity.ok(serviceContasAReceber.findByTipoRecebimento(tipoRecebimento));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContasAReceber> cadastrar(@Valid @RequestBody ContasAReceber contasAReceber) {
        return ResponseEntity.ok(serviceContasAReceber.cadastrar(contasAReceber));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ContasAReceber> alterar(@PathVariable Long id, @RequestBody ContasAReceber contasAReceber) {
        return ResponseEntity.ok(serviceContasAReceber.alterar(contasAReceber));
    }

    @DeleteMapping(path = "/{id}")
    public String deletar(@PathVariable Long id) {
        serviceContasAReceber.deletar(id);
        return "Deletado";
    }
}
