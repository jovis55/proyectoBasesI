package com.example.proyectobases.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString


public class MultipleRespuesta extends SeleccionMultiple implements Serializable {

    @OneToMany(mappedBy = "multipleRespuesta")
    private List<Opcion> opcionCorrectaList;
}
