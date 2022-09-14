package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.exceptions.EntityNotFoundException;
import com.api.gerenciadordecontas.repository.Enderecos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEnderecos {
    @Autowired
    private Enderecos enderecosService;

    public List<com.api.gerenciadordecontas.model.Enderecos> buscarTodos(){
        return enderecosService.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.Enderecos> buscarId(Long id) {
        return Optional.ofNullable(enderecosService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public com.api.gerenciadordecontas.model.Enderecos cadastrar(com.api.gerenciadordecontas.model.Enderecos enderecos) {

        return this.enderecosService.save(enderecos);
    }

    public com.api.gerenciadordecontas.model.Enderecos alterar(com.api.gerenciadordecontas.model.Enderecos enderecos, Long id) {
         enderecosService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));
        return this.enderecosService.save(enderecos);
    }

    public void deletar(Long id) {
        enderecosService.deleteById(id);
    }
}
