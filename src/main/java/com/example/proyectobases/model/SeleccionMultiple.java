package com.example.proyectobases.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity

@Getter
@Setter
@ToString


public class SeleccionMultiple extends Pregunta implements Serializable {
    @Column(name="cantidadOpciones", nullable = false)
    private int cantidadOpciones;

    @OneToMany(mappedBy = "seleccionMultiple")
    private List<Opcion> opcionesList;


}
