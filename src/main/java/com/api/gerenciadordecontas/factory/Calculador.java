package com.api.gerenciadordecontas.factory;

import com.api.gerenciadordecontas.model.ContasAReceber;

import java.math.BigDecimal;

public interface Calculador {
    public BigDecimal calculoFactory(ContasAReceber contasAReceber);
}
