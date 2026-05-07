package com.project.demo.repositories;

import org.springframework.stereotype.Repository;

import com.project.demo.classes.Usuario;


@Repository
public interface UsuarioRepo {
    Usuario findById(int id);
    void save(Usuario usuario);
    void update(int id, Usuario usuario);
    void deleteById(int id);

}
