package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebimento;

import java.util.Date;

public class Factory {
    public static Calculador getStatus(RecebimentoAlugueis statusRecebimento, TipoRecebimento tipoRecebimento) {
        if (statusRecebimento == RecebimentoAlugueis.EM_ATRASO) {
            return new AtrasoMulta();
        } else if (statusRecebimento == RecebimentoAlugueis.EM_DIA) {
            return new EmDia();
        } else if (statusRecebimento == RecebimentoAlugueis.ADIANTADO) {
            return new Adiantado();
        } else if (tipoRecebimento == TipoRecebimento.EMPREGO_CLT) {
            return new Emprego_Clt();

        } else if (tipoRecebimento == TipoRecebimento.FREELANCER) {
            return new Freelancer();

        } else {
            return null;
        }
    }
}

