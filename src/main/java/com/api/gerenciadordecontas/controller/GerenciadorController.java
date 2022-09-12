package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import com.api.gerenciadordecontas.model.ModelRequest;
import com.api.gerenciadordecontas.model.ModelResponse;
import com.api.gerenciadordecontas.model.ModelEntity;
import com.api.gerenciadordecontas.service.GerenciadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Tag(name= "CRUD de contas a pagar")
@RestController
@RequestMapping(path = "/contas")
@Validated
public class GerenciadorController {
    @Autowired
    private GerenciadorService gerenciadorService;

    @PostMapping
    @Operation(summary = "Operação para realizar cadastro de contas")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrar( @Valid @RequestBody ModelRequest modelRequest) {
        if (gerenciadorService.existsByNome(modelRequest.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome já está em uso!");
        }
        return ResponseEntity.ok(gerenciadorService.cadastrar(modelRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModelEntity> buscarPorID(@Parameter(description = "ID da conta") @PathVariable Long id) {
        return ResponseEntity.ok(gerenciadorService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ModelResponse>> buscarTodos() {
        return ResponseEntity.ok(gerenciadorService.buscarTodos());
    }

    @GetMapping(path = "/status/{statusContas}")
    public ResponseEntity<Object> findByStatusContas(@PathVariable StatusContas statusContas) {
        return ResponseEntity.ok(gerenciadorService.findByStatuContas(statusContas));
    }

    @GetMapping(path = "/tipo/{tipoContas}")
    public ResponseEntity<List<ModelEntity>> findByTipoContas(@PathVariable TipoContas tipoContas) {
        return ResponseEntity.ok(gerenciadorService.findByTipoContas(tipoContas));
    }


    @PatchMapping(path = "/{id}")
    public ResponseEntity<ModelEntity> alterarStatus(@Valid @RequestBody ModelEntity modelEntity) {
        return ResponseEntity.ok(gerenciadorService.alterarCadastro(modelEntity));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        gerenciadorService.deletar(id);
    }
}




