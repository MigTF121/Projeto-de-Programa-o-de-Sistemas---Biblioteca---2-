package com.project.demo.repositories;


import org.springframework.stereotype.Repository;

import com.project.demo.classes.Emprestimo;


@Repository
public interface EmprestimoRepo {
    Emprestimo findById(int id);
    void save(Emprestimo emprestimo);
    void update(int id, Emprestimo emprestimo);
    void deleteById(int id);

}
