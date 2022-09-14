package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.exceptions.EntityNotFoundException;
import com.api.gerenciadordecontas.repository.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEstados {
    @Autowired
    private Estados estadosService;

    public List<com.api.gerenciadordecontas.model.Estados> buscarTodos() {
        return estadosService.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.Estados> buscarId(Long id) {
        return Optional.ofNullable(estadosService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public com.api.gerenciadordecontas.model.Estados cadastrar(com.api.gerenciadordecontas.model.Estados estados) {

        return this.estadosService.save(estados);
    }

    public com.api.gerenciadordecontas.model.Estados alterar(com.api.gerenciadordecontas.model.Estados estados, Long id) {
                estadosService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));
                return estadosService.save(estados);

    }

    public void deletar(Long id) {
        estadosService.deleteById(id);
    }
}
