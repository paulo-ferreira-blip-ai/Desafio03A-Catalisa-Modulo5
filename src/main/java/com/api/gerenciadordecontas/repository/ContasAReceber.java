package com.api.gerenciadordecontas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAReceber extends JpaRepository<com.api.gerenciadordecontas.model.ContasAReceber, Long> {
}
