package com.example.proyectobases.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Profesor extends Usuario implements Serializable  {

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String titulo;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "profesor")
    private List<Evaluacion> evaluacionList;

    @OneToMany(mappedBy = "profesor")
    private List<BancoPreguntas> bancoPreguntasList;

    @OneToMany(mappedBy = "profesor")
    private List<Pregunta> preguntaList;

}
