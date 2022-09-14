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

    public Optional<com.api.gerenciadordecontas.model.Enderecos> buscarId(Long codigo) {
        return Optional.ofNullable(enderecosService.findById(codigo).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + codigo)));
    }

    public com.api.gerenciadordecontas.model.Enderecos cadastrar(com.api.gerenciadordecontas.model.Enderecos enderecos) {

        return this.enderecosService.save(enderecos);
    }

    public com.api.gerenciadordecontas.model.Enderecos alterar(com.api.gerenciadordecontas.model.Enderecos enderecos, Long codigo) {
         enderecosService.findById(codigo).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + codigo));
        return this.enderecosService.save(enderecos);
    }

    public void deletar(Long codigo) {
        enderecosService.deleteById(codigo);
    }
}
