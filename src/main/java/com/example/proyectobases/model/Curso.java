package com.example.proyectobases.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Curso implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "curso")
    private List<GrupoCurso> Grupocursos;

    @OneToOne(mappedBy = "curso")
    private PlanEstudio planEstudio;






}
