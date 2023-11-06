package com.example.proyectobases.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString


public class UnicaRespuesta extends SeleccionMultiple implements Serializable {

    @OneToOne
    private Opcion opcionCorrecta;
}
