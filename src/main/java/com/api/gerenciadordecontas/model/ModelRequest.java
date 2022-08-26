package com.api.gerenciadordecontas.model;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelRequest {

    private String nome;
    private double valor;
    private LocalDateTime dataDeCadastro;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private StatusContas statusContas;
    private TipoContas tipoContas;
}
