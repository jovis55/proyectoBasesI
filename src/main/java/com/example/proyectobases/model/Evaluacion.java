package com.example.proyectobases.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Evaluacion {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( length = 10, nullable = false)
    private int id;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="fechaCreacion", length = 100, nullable = false)
    private LocalDate fechaCreacion;

    @Column(name="tiempoLimite", length = 100, nullable = false)
    private LocalTime tiempoLimite;

    @Column(name="numPreguntas",nullable = false)
    private int numPreguntas;

    @Column(name="horaInicio",  nullable = false)
    private LocalTime horaInicio;

    @Column(name="horaFin", nullable = false)
    private LocalTime horaFin;

    @Column(name="valorPorcentual", nullable = false)
    private double valorPorcentual;

    @Column(name="puntajeAprobacion", nullable = false)
    private double puntajeAprobacion;

    @Column(name="cantidadIntentos", nullable = false)
    private int cantidadIntentos;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipoEvaluacion", length = 10, nullable = false)
    private TipoEvaluacion tipoEvaluacion;

    @OneToMany(mappedBy = "evaluacion")
    private List<Pregunta> preguntaList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Profesor profesor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tema", length = 10, nullable = false)
    private Tema tema;

    @OneToMany(mappedBy = "evaluacion")
    private List<EstudianteEvaluacion> estudianteEvaluaciones;

}
