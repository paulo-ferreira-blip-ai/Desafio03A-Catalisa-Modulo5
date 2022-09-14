package com.api.gerenciadordecontas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@Validated
public class Usuarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotEmpty
    private String nomeUsuario;

    private LocalDate dataNascimento;

    @Email
    @NotEmpty
    private String email;
    @CPF
    @NotEmpty
    private String cpf;


    @ManyToOne
    @JoinColumn(name = "enderecos_id", referencedColumnName = "codigo")
    private Enderecos enderecos;

}
