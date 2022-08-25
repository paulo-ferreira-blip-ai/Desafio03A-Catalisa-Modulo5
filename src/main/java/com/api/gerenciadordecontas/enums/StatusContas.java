package com.api.gerenciadordecontas.enums;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public enum StatusContas {
    AGUARDANDO,
    PAGO,
    VENCIDA;

    public static StatusContas condicoes(LocalDate dataVencimento, LocalDate dataCadastro) {
        if (dataVencimento.isBefore(dataCadastro)) {
            return VENCIDA;
        } else {
            return AGUARDANDO;
        }

    }

}

