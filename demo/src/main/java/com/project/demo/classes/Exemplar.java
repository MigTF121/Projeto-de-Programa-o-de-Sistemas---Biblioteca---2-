package com.project.demo.classes;
public class Exemplar {
    private int codigoExemplar;
    private boolean disponivel;
    private Livro livro;

    public Exemplar(int codigoExemplar, Livro livro) {
        if (codigoExemplar <= 0) {
            throw new IllegalArgumentException("Código do exemplar inválido.");
        }

        if (livro == null) {
            throw new IllegalArgumentException("Livro inválido.");
        }

        this.codigoExemplar = codigoExemplar;
        this.livro = livro;
        this.disponivel = true;
    }

    public int getCodigoExemplar() {
        return codigoExemplar;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Livro getLivro() {
        return livro;
    }

    public void emprestar() {
        if (!disponivel) {
            throw new IllegalArgumentException("Exemplar já emprestado.");
        }
        disponivel = false;
    }

    public void devolver() {
        if (disponivel) {
            throw new IllegalArgumentException("Exemplar já disponível.");
        }
        disponivel = true;
    }

    @Override
    public String toString() {
        return "Exemplar: " + codigoExemplar +
                " | Livro: " + livro.getTitulo() +
                " (Código: " + livro.getCodigoLivro() + ")" +
                " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}