package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.exceptions.EntityNotFoundException;
import com.api.gerenciadordecontas.repository.Cidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCidades {

    @Autowired
    private Cidades cidadesService;

    public List<com.api.gerenciadordecontas.model.Cidades> buscarTodos() {
        return cidadesService.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.Cidades> buscarId(Long id) {

        return Optional.ofNullable(cidadesService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public com.api.gerenciadordecontas.model.Cidades cadastrar(com.api.gerenciadordecontas.model.Cidades cidades) {

        return this.cidadesService.save(cidades);
    }

    public com.api.gerenciadordecontas.model.Cidades alterar(com.api.gerenciadordecontas.model.Cidades cidades,Long id) {
                cidadesService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));
        return this.cidadesService.save(cidades);
    }

    public void deletar(Long id) {
        cidadesService.deleteById(id);
    }


}
