package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.exceptions.EntityNotFoundException;
import com.api.gerenciadordecontas.model.ModelEntity;
import com.api.gerenciadordecontas.model.ModelResponse;
import com.api.gerenciadordecontas.model.ResponseUsuarios;
import com.api.gerenciadordecontas.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceUsuarios {
    @Autowired
    private Usuarios usuarios;

    public List<ResponseUsuarios> buscarTodos(){
        List< com.api.gerenciadordecontas.model.Usuarios> campos = usuarios.findAll();
        return campos.stream().map(campo -> new ResponseUsuarios(campo.getId(), campo.getNomeUsuario(),campo.getDataNascimento(), campo.getEmail())).collect(Collectors.toList());

    }

    public Optional<com.api.gerenciadordecontas.model.Usuarios> buscarId(Long id ){
        return Optional.ofNullable(usuarios.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public ResponseUsuarios cadastrar(com.api.gerenciadordecontas.model.Usuarios usuarios){


        this.usuarios.save(usuarios);

        ResponseUsuarios response = new ResponseUsuarios(usuarios.getId(), usuarios.getNomeUsuario(), usuarios.getDataNascimento(), usuarios.getEmail());
        return response;
    }

    public com.api.gerenciadordecontas.model.Usuarios alterar(com.api.gerenciadordecontas.model.Usuarios usuarios){
        return this.usuarios.save(usuarios);
    }

    public void deletar(Long id){
        usuarios.deleteById(id);
    }
}
