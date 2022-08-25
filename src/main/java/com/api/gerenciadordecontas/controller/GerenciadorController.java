package com.api.gerenciadordecontas.controller;

import com.api.gerenciadordecontas.model.ModelRequest;
import com.api.gerenciadordecontas.repository.GerenciadorRepository;
import com.api.gerenciadordecontas.repository.ModelEntity;
import com.api.gerenciadordecontas.service.GerenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        modelRequest.setDataDeCadastro(LocalDate.now(ZoneId.of("UTC-03:00")));
        return ResponseEntity.ok(gerenciadorService.cadastrar(modelRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ModelEntity>> buscarPorID(@PathVariable Long id) {
        if (!gerenciadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gerenciadorService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ModelEntity>> buscarTodos(ModelEntity modelEntity){
        return ResponseEntity.ok(gerenciadorService.buscarTodos(modelEntity));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ModelEntity> alterarStatus(@PathVariable Long id, @RequestBody ModelEntity modelEntity) {
        if (!gerenciadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gerenciadorService.alterarCadastro(modelEntity));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!gerenciadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
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




