package com.project.demo.repositories;


import org.springframework.stereotype.Repository;

import com.project.demo.classes.Pessoa;


@Repository
public interface PessoaRepo {
    Pessoa findById(int id);
    void save(Pessoa pessoa);
    void update(int id, Pessoa pessoa);
    void deleteById(int id);
    
}
