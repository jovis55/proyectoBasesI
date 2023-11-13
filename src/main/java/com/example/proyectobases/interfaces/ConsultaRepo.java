package com.example.proyectobases.interfaces;
import com.example.proyectobases.model.Estudiante;
import com.example.proyectobases.model.EstudianteEvaluacion;
import com.example.proyectobases.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConsultaRepo extends JpaRepository<Reporte, Long> {
    // Agrega métodos de consulta personalizados si es necesario

    // Método personalizado con consulta SQL
    @Query(value = "SELECT e.evaluacion_id, e.calificacion FROM Estudiante_Evaluacion e WHERE e.codigo = :valor", nativeQuery = true)
    List<EstudianteEvaluacion> findByAlgunaColumna(@Param("valor") String valor);


}
