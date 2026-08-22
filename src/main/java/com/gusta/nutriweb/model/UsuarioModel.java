package com.gusta.nutriweb.model;

import com.gusta.nutriweb.enums.GeneroEnum;
import com.gusta.nutriweb.enums.NivelAtividadeEnum;
import com.gusta.nutriweb.enums.ObjetivoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_usuarios")
@Entity
public class UsuarioModel {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull
    private LocalDate dataNascimento;
    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    @Column(name = "peso")
    @Positive
    private Double peso;

    @Column(name = "objetivo")
    @Enumerated(EnumType.STRING)
    private ObjetivoEnum objetivo;

    @Column(name = "atividade_fisica")
    @Enumerated(EnumType.STRING)
    private NivelAtividadeEnum nivelAtividade;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InformacoesModel> historico = new ArrayList<>();

}
