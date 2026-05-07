package com.project.demo.repositories;


import org.springframework.stereotype.Repository;

import com.project.demo.classes.Funcionario;


@Repository
public interface FuncionarioRepo {
    Funcionario findById(int id);
    void save(Funcionario funcionario);
    void update(int id, Funcionario funcionario);
    void deleteById(int id);
    
}
