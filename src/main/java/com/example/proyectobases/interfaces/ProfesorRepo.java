package com.example.proyectobases.interfaces;

import com.example.proyectobases.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorRepo extends JpaRepository<Profesor, String> {

    List<Profesor> findAll();
}
