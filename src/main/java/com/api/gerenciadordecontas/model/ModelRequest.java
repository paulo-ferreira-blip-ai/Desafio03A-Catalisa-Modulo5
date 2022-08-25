package com.api.gerenciadordecontas.model;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelRequest {
    @NotBlank(message = "Campo nome vazio")
    private String nome;
    @NotBlank(message = "Campo valor vazio")
    private double valor;

    private LocalDate dataDeCadastro;
    @NotBlank(message = "Campo data de vencimento vazio")
    private LocalDate dataDeVencimento;

    private LocalDate dataDePagamento;

    private StatusContas statusContas;
    @NotBlank(message = "Campo tipo de contas vazio")
    private TipoContas tipoContas;
}
