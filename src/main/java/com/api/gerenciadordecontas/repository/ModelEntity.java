package com.api.gerenciadordecontas.repository;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "gerenciador_de_contas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotBlank(message = "Campo nome vazio")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @Column(name = "dataDeVencimento")
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate dataDeVencimento;

    @Column(name = "dataDePagamento")
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;

    @Column(name = "dataDeCadastro")
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDeCadastro;

    @Column(name = "statusContas")
    @Enumerated(value = EnumType.STRING)
    private StatusContas statusContas;

    @Column(name = "tipoContas")
    @Enumerated(value = EnumType.STRING)
    private TipoContas tipoContas;
}

