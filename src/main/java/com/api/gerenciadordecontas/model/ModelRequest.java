package com.api.gerenciadordecontas.model;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class ModelRequest {

    @NotEmpty
    @NotNull
    private String nome;
    @Min(value = 1)
    private double valor;
    private LocalDateTime dataDeCadastro;
    @NotNull
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private StatusContas statusContas;
    @NotNull
    private TipoContas tipoContas;
}
