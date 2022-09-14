package com.api.gerenciadordecontas.model;

import com.api.gerenciadordecontas.enums.StatusContas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelResponse {
    private Long codigo;
    private String nome;
    private double valor;
    private StatusContas statusContas;
}
