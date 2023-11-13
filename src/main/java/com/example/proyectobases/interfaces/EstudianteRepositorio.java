package com.example.proyectobases.interfaces;

import com.example.proyectobases.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante,String> {
    List<Estudiante> findAll();

}
