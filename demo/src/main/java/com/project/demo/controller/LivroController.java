package com.project.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.classes.Livro;
import com.project.demo.repositories.LivroRepo;

@RestController
public class LivroController {

    LivroRepo livroRepo;

    public LivroController(LivroRepo livroRepo) {
        this.livroRepo = livroRepo;
    }

    @GetMapping("/livros")
    public List<Livro> getAllLivros() {
        return livroRepo.findAll();
    }

    @GetMapping("/livros/{id}")
    public void getLivroById(@PathVariable Integer id) {
        livroRepo.findById(id);
    }

    @PostMapping("/livros")
    public void createLivro(@RequestBody Livro livro) {
        livroRepo.save(livro);
    }

    @DeleteMapping("/livros/{id}")
    public void deleteLivro(@PathVariable Integer id) {
        livroRepo.deleteById(id);
    }
}
