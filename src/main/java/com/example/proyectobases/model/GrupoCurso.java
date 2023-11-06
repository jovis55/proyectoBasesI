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
public class GrupoCurso implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Grupo grupo;



}
