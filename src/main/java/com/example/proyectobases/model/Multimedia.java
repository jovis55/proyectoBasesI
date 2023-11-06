package com.example.proyectobases.model;

import java.io.File;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Multimedia extends Pregunta implements Serializable {

    @Column(nullable = false)
    private File multimedia;


    @Column(nullable = false)
    private  TipoMultimedia tipoMultimedia;


}
