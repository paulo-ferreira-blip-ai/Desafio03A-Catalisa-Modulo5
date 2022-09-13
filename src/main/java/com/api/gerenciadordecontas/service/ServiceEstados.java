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
    private Estados estados;

    public List<com.api.gerenciadordecontas.model.Estados> buscarTodos(){
        return estados.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.Estados> buscarId(Long id ){
        return Optional.ofNullable(estados.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public com.api.gerenciadordecontas.model.Estados cadastrar(com.api.gerenciadordecontas.model.Estados estados){

        return this.estados.save(estados);
    }

    public com.api.gerenciadordecontas.model.Estados alterar(com.api.gerenciadordecontas.model.Estados estados){
        return this.estados.save(estados);
    }

    public void deletar(Long id){
        estados.deleteById(id);
    }
}
