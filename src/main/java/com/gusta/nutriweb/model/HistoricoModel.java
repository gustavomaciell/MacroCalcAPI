package com.gusta.nutriweb.model;

import jakarta.persistence.*;

public class HistoricoModel {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;
}
