package com.api.gerenciadordecontas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidades")
@Validated
public class Cidades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty
    @NotNull
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estados_id", referencedColumnName = "codigo")
    private Estados estados;

//    @OneToMany(mappedBy = "enderecos", cascade = CascadeType.ALL)
//    private List<Enderecos> enderecos;


}
