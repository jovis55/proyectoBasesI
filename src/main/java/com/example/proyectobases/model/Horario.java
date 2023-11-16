package com.example.proyectobases.model;


import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Horario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idHorario", length = 10, nullable = false)
    private int idHorario;

    @Column(name="lugar", length = 100, nullable = false)
    private String lugar;

    @Column(name="dia", length = 100, nullable = false)
    private LocalDate dia;

    @Column(name="horaInicio", length = 100, nullable = false)
    private LocalTime horaInicio;

    @Column(name="horaFin", length = 100, nullable = false)
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;



}
