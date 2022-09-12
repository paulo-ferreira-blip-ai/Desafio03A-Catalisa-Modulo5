package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.model.ContasAReceber;

import java.math.BigDecimal;

public class Adiantado implements Calculador{
    @Override
    public BigDecimal calculoFactory(ContasAReceber contasAReceber) {

        BigDecimal ret = contasAReceber.getValorRecebimento().multiply(new BigDecimal(String.valueOf(0.05)));
        return contasAReceber.getValorRecebimento().subtract(ret);
    }
}
