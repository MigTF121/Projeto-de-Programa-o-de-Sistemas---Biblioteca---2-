package com.project.demo.classes;
import java.util.ArrayList;

public class Livro {

    private int codigoLivro;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private ArrayList<Exemplar> exemplares;

    public Livro(int codigoLivro, String titulo, String autor, int anoPublicacao) {
        if (codigoLivro <= 0) {
            throw new IllegalArgumentException("Código do livro inválido.");
        }

        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título inválido.");
        }

        if (anoPublicacao < 0) {
            throw new IllegalArgumentException("Ano inválido.");
        }

        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("Autor inválido.");
        }
        
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<>();
    }

    public Livro(int codigoLivro, String titulo) {
        this(codigoLivro, titulo, "Autor desconhecido", 0);
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public ArrayList<Exemplar> getExemplares() {
        return new ArrayList<>(exemplares);
    }

    public void adicionarExemplar(Exemplar e) {
        exemplares.add(e);
    }

    public void listarExemplaresDisponiveis() {
        boolean encontrou = false;

        for (Exemplar e : exemplares) {
            if (e.isDisponivel()) {
                System.out.println(e);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum exemplar disponível para este livro.");
        }
    }

    public int getQuantidadeDisponiveis() {
        int count = 0;
        for (Exemplar e : exemplares) {
            if (e.isDisponivel()) {
                count++;
            }
        }
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