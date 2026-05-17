package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.demo.classes.Exemplar;
import java.util.List;

@Repository
public interface ExemplarRepo extends JpaRepository<Exemplar, Integer> {
    List<Exemplar> findByDisponivelTrue();
}


