package com.api.gerenciadordecontas.model;

import com.api.gerenciadordecontas.enums.RecebimentoAlugueis;
import com.api.gerenciadordecontas.enums.StatusContas;
import com.api.gerenciadordecontas.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contas_a_receber")
@Validated
public class ContasAReceber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String recebimento;

    private BigDecimal valorRecebimento;

    @Enumerated(value = EnumType.STRING)
    private TipoRecebimento tipoRecebimento;

    private LocalDate dataDeVencimento;

    private LocalDate dataDeRecebimento;

    @Enumerated(value = EnumType.STRING)
    private RecebimentoAlugueis status;


    @ManyToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuarios usuarios;


}
