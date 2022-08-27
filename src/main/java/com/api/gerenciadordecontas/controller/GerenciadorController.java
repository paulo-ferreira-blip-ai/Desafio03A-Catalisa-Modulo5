package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import com.api.gerenciadordecontas.model.ModelRequest;
import com.api.gerenciadordecontas.model.ModelResponse;
import com.api.gerenciadordecontas.repository.GerenciadorRepository;
import com.api.gerenciadordecontas.repository.ModelEntity;
import com.api.gerenciadordecontas.service.GerenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/contas")
public class GerenciadorController {
    @Autowired
    private GerenciadorService gerenciadorService;
    @Autowired
    private GerenciadorRepository gerenciadorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrar(@RequestBody ModelRequest modelRequest) {
        if (gerenciadorService.existsByNome(modelRequest.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome já está em uso!");
        }

        modelRequest.setDataDeCadastro(LocalDateTime.now(ZoneId.of("UTC-03:00")));

        return ResponseEntity.ok(gerenciadorService.cadastrar(modelRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModelEntity> buscarPorID(@PathVariable Long id) {
        if (!gerenciadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gerenciadorService.buscarPorId(id));
    }

    @GetMapping(path = "/status/{statusContas}")
    public ResponseEntity<List<ModelEntity>> findByStatusContas(@PathVariable StatusContas statusContas) {
        return ResponseEntity.ok(gerenciadorService.findByStatuContas(statusContas));
    }

    @GetMapping(path = "/tipo/{tipoContas}")
    public ResponseEntity<List<ModelEntity>> findByTipoContas(@PathVariable TipoContas tipoContas) {
        return ResponseEntity.ok(gerenciadorService.findByTipoContas(tipoContas));
    }

    @GetMapping
    public ResponseEntity<List<ModelResponse>> buscarTodos() {
        return ResponseEntity.ok(gerenciadorService.buscarTodos());
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ModelEntity> alterarStatus(@PathVariable Long id, @RequestBody ModelEntity modelEntity) {
        if (!gerenciadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gerenciadorService.alterarCadastro(modelEntity));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!gerenciadorRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        gerenciadorService.deletar(id);
        return null;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validacaoDeErros(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campoNome = ((FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();
            errors.put(campoNome, mensagemDeErro);
        });
        return errors;
    }
}




