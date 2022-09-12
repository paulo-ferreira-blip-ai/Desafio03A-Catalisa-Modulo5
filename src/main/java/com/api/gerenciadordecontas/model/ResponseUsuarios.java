package com.api.gerenciadordecontas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUsuarios {
    private Long id;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;

}
