package com.example.proyectobases.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Opcion implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String opcion;

    @ManyToOne(fetch = FetchType.EAGER)
    private SeleccionMultiple seleccionMultiple;

    @OneToOne(mappedBy = "opcionCorrecta")
    private UnicaRespuesta unicaRespuesta;

    @ManyToOne(fetch = FetchType.EAGER)
    private MultipleRespuesta multipleRespuesta;

    @OneToMany(mappedBy = "respuestaOpcion")
    private List<RespuestaEstudiante> respuestaEstudiantes;
}
