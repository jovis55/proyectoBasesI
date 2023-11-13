package com.example.proyectobases.interfaces;

import com.example.proyectobases.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepositorio extends JpaRepository<Evaluacion, Integer> {
    List<Evaluacion> findAll();
}
