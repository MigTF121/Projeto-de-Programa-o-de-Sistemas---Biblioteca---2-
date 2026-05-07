package com.project.demo.repositories;


import org.springframework.stereotype.Repository;

import com.project.demo.classes.Livro;


@Repository
public interface LivroRepo {
    Livro findById(int id);
    void save(Livro livro);
    void update(int id, Livro livro);
    void deleteById(int id);

}
