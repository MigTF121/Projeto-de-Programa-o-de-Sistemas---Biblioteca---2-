package com.project.demo.classes;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoLivro;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    private int anoPublicacao;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Exemplar> exemplares = new ArrayList<>();

    public Livro() {}

    public Livro(String titulo, String autor, int anoPublicacao) {
        if (titulo == null || titulo.isEmpty())
            throw new IllegalArgumentException("Título inválido.");

        if (autor == null || autor.isEmpty())
            throw new IllegalArgumentException("Autor inválido.");

        if (anoPublicacao < 0)
            throw new IllegalArgumentException("Ano inválido.");

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<>();
    }

    public int getCodigoLivro() { return codigoLivro; }

    public String getTitulo() { return titulo; }

    public String getAutor() { return autor; }

    public List<Exemplar> getExemplares() { return new ArrayList<>(exemplares); }

    public void adicionarExemplar(Exemplar e) { exemplares.add(e); }

    public void listarExemplaresDisponiveis() {
        boolean encontrou = false;
        for (Exemplar e : exemplares) {
            if (e.isDisponivel()) {
                System.out.println(e);
                encontrou = true;
            }
        }
        if (!encontrou)
            System.out.println("Nenhum exemplar disponível para este livro.");
    }

    public int getQuantidadeDisponiveis() {
        int count = 0;
        for (Exemplar e : exemplares)
            if (e.isDisponivel()) count++;
        return count;
    }

    @Override
    public String toString() {
        return "Código: " + codigoLivro +
               "\nTítulo: " + titulo +
               "\nAutor: " + autor +
               "\nAno: " + anoPublicacao;
    }
}