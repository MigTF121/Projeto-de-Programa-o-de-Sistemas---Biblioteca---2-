package com.project.demo.classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "exemplar_id", nullable = false)
    private Exemplar exemplar;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoReal;

    public Emprestimo() {
    }

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        if (usuario == null || exemplar == null) {
            throw new IllegalArgumentException("Usuário ou Exemplar não podem ser nulos.");
        }

        if (!exemplar.isDisponivel()) {
            throw new IllegalStateException("Este exemplar já está emprestado.");
        }

        if (!usuario.podeEmprestar()) {
            throw new IllegalStateException("Usuário atingiu o limite de empréstimos.");
        }

        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();

        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(15);

        // Atualiza o status do exemplar e do usuário
        exemplar.emprestar();
        usuario.adicionarLivroEmprestado(exemplar);
    }

    public void registrarDevolucao() {
        if (dataDevolucaoReal != null) {
            throw new IllegalStateException("Este empréstimo já foi devolvido.");
        }

        this.dataDevolucaoReal = LocalDate.now();

        // Atualiza os status
        exemplar.devolver();
        usuario.removerLivroEmprestado(exemplar);
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    @Override
    public String toString() {
        return "Empréstimo ID: " + id +
                " | Usuário: " + usuario.getNomeCompleto() +
                " | Livro: " + exemplar.getLivro().getTitulo() +
                " | Previsão: " + dataDevolucaoPrevista;
    }
}