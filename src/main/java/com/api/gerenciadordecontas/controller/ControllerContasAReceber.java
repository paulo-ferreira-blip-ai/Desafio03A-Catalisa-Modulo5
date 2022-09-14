package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebido;
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

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<ContasAReceber>> buscarPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(serviceContasAReceber.buscarId(codigo));
    }

    @GetMapping(path = "/recebido/{tipoRecebido}")
    public ResponseEntity<List<ContasAReceber>> findByTipoRecebimento(@PathVariable TipoRecebido tipoRecebido) {
        return ResponseEntity.ok(serviceContasAReceber.findByTipoRecebido(tipoRecebido));
    }

    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<ContasAReceber>> findByTipoRecebimento(@PathVariable RecebimentoAlugueis status) {
        return ResponseEntity.ok(serviceContasAReceber.findByStatus(status));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContasAReceber> cadastrar(@Valid @RequestBody ContasAReceber contasAReceber) {
        return ResponseEntity.ok(serviceContasAReceber.cadastrar(contasAReceber));
    }

    @PatchMapping(path = "/{codigo}")
    public ResponseEntity<ContasAReceber> alterar(@PathVariable Long codigo, @RequestBody ContasAReceber contasAReceber) {
        return ResponseEntity.ok(serviceContasAReceber.alterar(contasAReceber, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletar(@PathVariable Long codigo) {
        serviceContasAReceber.deletar(codigo);
        return "Deletado";
    }
}
