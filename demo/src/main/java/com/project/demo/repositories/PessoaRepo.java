package com.project.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.classes.Pessoa;


@Repository
public interface PessoaRepo extends JpaRepository<Pessoa, Integer> {

}
