package com.api.gerenciadordecontas.repository;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAReceber extends JpaRepository<com.api.gerenciadordecontas.model.ContasAReceber, Long> {
    public List<com.api.gerenciadordecontas.model.ContasAReceber> findByTipoRecebimento(TipoRecebimento tipoRecebimento);

    public List<com.api.gerenciadordecontas.model.ContasAReceber> findByStatus(RecebimentoAlugueis status);

}
