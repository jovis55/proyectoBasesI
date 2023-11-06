package com.example.proyectobases.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS )
@Getter
@Setter
//@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(name="idUsuario", length = 10, nullable = false)
    private String idUsuario;

    @Column(name="email", length = 50, unique = true)
    private String email;

    @Column(name="contrasena", length = 30, nullable = false)
    private String contrasena;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="apellido", length = 300, nullable = false)
    private String apellido;

}