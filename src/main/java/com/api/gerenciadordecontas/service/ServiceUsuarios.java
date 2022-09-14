package com.api.gerenciadordecontas.service;

import com.api.gerenciadordecontas.exceptions.EntityNotFoundException;
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
    private Usuarios usuariosService;

    public List<ResponseUsuarios> buscarTodos() {
        List<com.api.gerenciadordecontas.model.Usuarios> campos = usuariosService.findAll();
        return campos.stream().map(campo -> new ResponseUsuarios(campo.getCodigo(), campo.getNomeUsuario(),
                campo.getDataNascimento(), campo.getEmail())).collect(Collectors.toList());

    }

    public Optional<com.api.gerenciadordecontas.model.Usuarios> buscarId(Long codigo) {
        return Optional.ofNullable(usuariosService.findById(codigo).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + codigo)));
    }

    public ResponseUsuarios cadastrar(com.api.gerenciadordecontas.model.Usuarios usuarios) {


        this.usuariosService.save(usuarios);

        ResponseUsuarios response = new ResponseUsuarios(usuarios.getCodigo(), usuarios.getNomeUsuario(),
                usuarios.getDataNascimento(), usuarios.getEmail());
        return response;
    }

    public com.api.gerenciadordecontas.model.Usuarios alterar(com.api.gerenciadordecontas.model.Usuarios usuarios, Long codigo) {
                usuariosService.findById(codigo).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + codigo));
                return usuariosService.save(usuarios);
    }

    public void deletar(Long codigo) {
        usuariosService.deleteById(codigo);
    }
}
