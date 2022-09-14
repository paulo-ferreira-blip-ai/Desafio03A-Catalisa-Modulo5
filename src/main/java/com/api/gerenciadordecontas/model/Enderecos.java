package com.api.gerenciadordecontas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enderecos")
@Validated
public class Enderecos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotEmpty
    private String logradouro;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String pontoReferencia;


    @ManyToOne
    @JoinColumn(name = "cidades_id", referencedColumnName = "codigo")
    private Cidades cidades;


}
