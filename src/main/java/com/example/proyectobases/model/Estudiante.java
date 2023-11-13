package com.example.proyectobases.model;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")

public class Estudiante extends Usuario implements Serializable {

    @Column(name="telefonoAcudiente", length = 20, nullable = false)
    private String telefonoAcudiente;

    @Column(name="fechaNacimiento", nullable = true)
    private Date fechaNacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Grupo grupo;

    @OneToMany(mappedBy = "id_usuario")
    private List<EstudianteEvaluacion> estudianteEvaluaciones;

    @OneToMany(mappedBy = "estudiante")
    private List<RespuestaEstudiante> respuestaEstudianteList;




}

