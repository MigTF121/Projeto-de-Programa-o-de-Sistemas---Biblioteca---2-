package com.project.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.classes.Emprestimo;
import com.project.demo.classes.Exemplar;
import com.project.demo.classes.Funcionario;
import com.project.demo.classes.Livro;



@RestController
public class BibliotecaController {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public BibliotecaController() {
        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        livro1.adicionarExemplar(new Exemplar(101, livro1));
        livro1.adicionarExemplar(new Exemplar(102, livro1));

        Livro livro2 = new Livro(2, "1984", "George Orwell", 1949);
        livro2.adicionarExemplar(new Exemplar(201, livro2));
        livro2.adicionarExemplar(new Exemplar(202, livro2));

        livros.add(livro1);
        livros.add(livro2);
    }

    
}