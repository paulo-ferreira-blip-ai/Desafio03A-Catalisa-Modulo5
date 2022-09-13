package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.model.ContasAReceber;

import java.math.BigDecimal;

public class EmDia implements Calculador {
    @Override
    public BigDecimal calculoFactory(ContasAReceber contasAReceber) {
        return contasAReceber.getValorRecebimento();
    }
}
