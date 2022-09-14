package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoRecebimento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

import static com.api.gerenciadordecontas.enums.StatusContas.*;

public class Factory {
    public static Calculador getStatus(RecebimentoAlugueis status, TipoRecebimento tipoRecebimento) {
        if (status == RecebimentoAlugueis.EM_ATRASO) {
            return new AtrasoMulta();
        } else if (status == RecebimentoAlugueis.EM_DIA) {
            return new EmDia();
        } else if (status == RecebimentoAlugueis.ADIANTADO) {
            return new Adiantado();
        } else if (tipoRecebimento == TipoRecebimento.EMPREGO_CLT) {
            return new Emprego_Clt();

        } else if (tipoRecebimento == TipoRecebimento.FREELANCER) {
            return new Freelancer();

        } else {
            return null;
        }
    }


    public static StatusContas condicoes(LocalDate dataVencimento, LocalDateTime dataCadastro) {
        if (dataVencimento.isBefore(ChronoLocalDate.from(dataCadastro))){
            return VENCIDA;
        }   else {
            return AGUARDANDO;

        }
    }

    public static RecebimentoAlugueis mudarStatus(LocalDate dataVencimento, LocalDate dataRecebimento) {
        if (dataVencimento.isBefore(dataRecebimento)){
            return RecebimentoAlugueis.EM_ATRASO;
        } else if (dataVencimento.equals(dataRecebimento)) {
            return RecebimentoAlugueis.EM_DIA;

        } else if (dataVencimento.isAfter(dataRecebimento)) {
            return RecebimentoAlugueis.ADIANTADO;

        } else {
            return null;
        }
    }
}

