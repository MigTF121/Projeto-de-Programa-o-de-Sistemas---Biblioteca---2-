package com.project.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.classes.Funcionario;

@Repository
public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {
    
}
