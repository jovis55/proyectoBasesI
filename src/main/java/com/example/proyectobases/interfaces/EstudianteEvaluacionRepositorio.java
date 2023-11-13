package com.example.proyectobases.interfaces;

import com.example.proyectobases.model.EstudianteEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteEvaluacionRepositorio extends JpaRepository<EstudianteEvaluacion, Integer> {

    @Query(value = "SELECT e.codigo, e.calificacion FROM estudiante_evaluacion e WHERE e.codigo = :valor", nativeQuery = true)
    List<EstudianteEvaluacion> findByAlgunaColumna(@Param("valor") int valor);

    List<EstudianteEvaluacion> findAll();


}
