package com.project.demo.repositories;


import org.springframework.stereotype.Repository;

import com.project.demo.classes.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LivroRepo extends JpaRepository<Livro, Integer> {

}
