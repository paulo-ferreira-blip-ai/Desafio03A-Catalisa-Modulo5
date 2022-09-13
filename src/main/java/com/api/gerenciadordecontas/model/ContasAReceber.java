package com.api.gerenciadordecontas.model;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.TipoRecebimento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contas_a_receber")
public class ContasAReceber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String recebimento;

    private BigDecimal valorRecebimento;

    @Enumerated(value = EnumType.STRING)
    private TipoRecebimento tipoRecebimento;

    private LocalDateTime dataDeVencimento;

    private LocalDateTime dataDeRecebimento = LocalDateTime.now(ZoneId.of("UTC-03:00"));

    @Enumerated(value = EnumType.STRING)
    private RecebimentoAlugueis recebimentoAlugueis;

    private String status;


    @ManyToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuarios usuarios;


}
