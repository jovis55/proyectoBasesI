package com.example.proyectobases.interfaces;

import com.example.proyectobases.model.EstudianteEvaluacion;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteEvaluacionRepositorio extends JpaRepository<EstudianteEvaluacion, Integer> {

    List<EstudianteEvaluacion> findAll();
    List<EstudianteEvaluacion> findByEstudianteIdUsuario(String codigo);
    List<EstudianteEvaluacion> findByEstudianteIdUsuarioAndCalificacionGreaterThan(String codigo, double nota);
    List<EstudianteEvaluacion> findByEvaluacion_Id(int codigo);


}
