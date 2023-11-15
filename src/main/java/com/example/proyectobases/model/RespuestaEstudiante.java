package com.example.proyectobases.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Optional;

@Entity
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RespuestaEstudiante implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private int id;

    @Column(name="respuesta", length = 100)
    private boolean respuesta;

    @Column(name="respuestaTexto", length = 100)
    private String respuestaTexto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Opcion respuestaOpcion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pregunta pregunta;

}
