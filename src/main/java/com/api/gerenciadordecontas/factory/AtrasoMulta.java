package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.model.ContasAReceber;

import java.math.BigDecimal;

public class AtrasoMulta implements Calculador {
    @Override
    public BigDecimal calculoFactory(ContasAReceber contasAReceber) {
        BigDecimal ret = contasAReceber.getValorRecebimento().multiply(new BigDecimal(String.valueOf(0.035)));
        return ret.add(contasAReceber.getValorRecebimento());
    }
}
