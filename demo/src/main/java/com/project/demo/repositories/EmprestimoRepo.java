package com.project.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.classes.Emprestimo;

@Repository
public interface EmprestimoRepo extends JpaRepository<Emprestimo, Integer> {
    
}
