package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.model.ResponseUsuarios;
import com.api.gerenciadordecontas.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuarios {
    @Autowired
    private Usuarios usuarios;

    public List<com.api.gerenciadordecontas.model.Usuarios> buscarTodos(){
        return usuarios.findAll();
    }

    public Optional<com.api.gerenciadordecontas.model.Usuarios> buscarId(Long id ){
        return usuarios.findById(id);
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
