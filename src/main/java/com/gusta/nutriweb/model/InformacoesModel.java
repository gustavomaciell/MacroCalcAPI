package com.gusta.nutriweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_informacoes")
@Entity
public class InformacoesModel {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "peso_atual")
    @Positive
    private Double pesoAtual;

    @Column(name = "kcal_diaria")
    private Integer kcalDiaria;

    @Column(name = "proteina_necessaria")
    private Double proteinasNecessarias;

    @Column(name = "carboidrato_necessario")
    private Double carboidratosNecessarios;

    @Column(name = "gordura_necessaria")
    private Double gordurasNecessarias;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;
}
