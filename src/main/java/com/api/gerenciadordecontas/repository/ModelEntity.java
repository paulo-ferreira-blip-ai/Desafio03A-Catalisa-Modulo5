package com.api.gerenciadordecontas.repository;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

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
    private String nome;

    @Column(name = "valor")
    private double valor;

    @Column(name = "dataDeVencimento")
    private LocalDate dataDeVencimento;

    @Column(name = "dataDePagamento")
    private LocalDate dataDePagamento;

    @Column(name = "dataDeCadastro")
    private LocalDate dataDeCadastro;

    @Column(name = "statusContas")
    @Enumerated(value = EnumType.STRING)
    private StatusContas statusContas;

    @Column(name = "tipoContas")
    @Enumerated(value = EnumType.STRING)
    private TipoContas tipoContas;

}

