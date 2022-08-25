package com.api.gerenciadordecontas.repository;

import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoContas;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface GerenciadorRepository extends JpaRepository<ModelEntity, Long> {
    public List<ModelEntity> findByStatusContas(StatusContas statusContas);

    public List<ModelEntity> findByTipoContas(TipoContas tipoContas);

    @Query(value = "select id,nome,valor,status_contas from gerenciador_de_contas")
    ArrayList<ModelEntity> minhasBuscas();

}
