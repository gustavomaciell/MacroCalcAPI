package com.gusta.nutriweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_alimento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AlimentoModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "proteinas")
    private Double proteina;

    @Column(name = "carboidratos")
    private Double carboidrato;

    @Column(name = "lipideos")
    private Double gordura;

    @Column(name = "kcal")
    private Double caloria;
}
