package com.example.proyectobases.model;

import java.io.Serial;
import java.io.Serializable;

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
@ToString
public class EstudianteEvaluacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Estudiante id_usuario;

    @ManyToOne
    private Evaluacion evaluacion;

    @Column(nullable = false)
    private double calificacion;

}
