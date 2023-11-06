package com.example.proyectobases.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
//@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pregunta {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Profesor profesor;

    @Column(name="enunciado", length = 100, nullable = false)
    private String enunciado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tema", length = 10, nullable = false)
    private Tema tema;

    @Column(name="puntosPregunta", nullable = false)
    private int puntosPregunta;

    @Column(name="fechaCreacion", length = 100, nullable = false)
    private LocalDate fechaCreacion;

    @Column(name="visibilidad", nullable = false)
    private boolean visibilidad;

    @ManyToOne(fetch = FetchType.EAGER)
    private Evaluacion evaluacion;

    @OneToMany(mappedBy = "pregunta")
    private List<BancoPreguntas> bancoPreguntasList;
}
