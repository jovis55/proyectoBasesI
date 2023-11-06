package com.example.proyectobases.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Grupo implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idGrupo", length = 10, nullable = false)
    private int idGrupo;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "grupo")
    private List<Estudiante> estudianteList;

    @OneToMany(mappedBy = "grupo")
    private List<GrupoCurso> grupoCursos;


}
