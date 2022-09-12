package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebimento;

import java.util.Date;

public class Factory {
    public static Calculador getStatus(RecebimentoAlugueis statusRecebimento) {
        if (statusRecebimento == RecebimentoAlugueis.EM_ATRASO) {
            return new AtrasoMulta();
        } else if (statusRecebimento == RecebimentoAlugueis.EM_DIA) {
            return new EmDia();
        } else if (statusRecebimento == RecebimentoAlugueis.ADIANTADO) {
            return new Adiantado();
        } else {
            return null;
        }
    }
}
