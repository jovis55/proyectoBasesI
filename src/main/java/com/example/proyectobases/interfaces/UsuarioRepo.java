package com.example.proyectobases.interfaces;

import com.example.proyectobases.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    List<Usuario> findAll();
}
