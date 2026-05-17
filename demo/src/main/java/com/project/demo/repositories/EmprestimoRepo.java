package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.classes.Emprestimo;

import java.util.List;

@Repository
public interface EmprestimoRepo extends JpaRepository<Emprestimo, Integer> {

    // Busca todos os empréstimos de um usuário específico pelo ID de registro.
    List<Emprestimo> findByUsuarioRegistroUsuario(int registroUsuario);
}