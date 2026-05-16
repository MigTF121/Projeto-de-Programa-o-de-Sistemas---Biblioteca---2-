package com.project.demo.repositories;

import org.springframework.stereotype.Repository;

import com.project.demo.classes.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}
