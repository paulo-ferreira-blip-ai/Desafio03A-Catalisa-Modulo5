package com.api.gerenciadordecontas.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;


public enum StatusContas {
    AGUARDANDO,
    PAGO,
    VENCIDA;

    public static StatusContas condicoes(LocalDate dataVencimento, LocalDateTime dataCadastro) {
        if (dataVencimento.isBefore(ChronoLocalDate.from(dataCadastro))) {
            return VENCIDA;
        } else {
            return AGUARDANDO;
        }
    }
}

