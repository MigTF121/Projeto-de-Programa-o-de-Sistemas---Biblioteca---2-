package com.project.demo.classes;
import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        if (usuario == null || exemplar == null) {
            throw new IllegalArgumentException("Dados inválidos.");
        }

        if (!exemplar.isDisponivel()) {
            throw new IllegalArgumentException("Exemplar já emprestado.");
        }

        if (!usuario.podeEmprestar()) {
            throw new IllegalArgumentException("Limite de livros atingido.");
        }

        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(15);

        exemplar.emprestar();
        usuario.adicionarLivroEmprestado(exemplar);
    }

    public void registrarDevolucao() {
        if (dataDevolucaoReal != null) {
            throw new IllegalArgumentException("Empréstimo já finalizado.");
        }

        this.dataDevolucaoReal = LocalDate.now();
        exemplar.devolver();
        usuario.removerLivroEmprestado(exemplar);
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
        return "Usuário: " + usuario.getNomeCompleto() +
                "\nLivro: " + exemplar.getLivro().getTitulo() +
                "\nExemplar: " + exemplar.getCodigoExemplar() +
                "\nData empréstimo: " + dataEmprestimo +
                "\nDevolução prevista: " + dataDevolucaoPrevista +
                "\nDevolução real: " + (dataDevolucaoReal != null ? dataDevolucaoReal : "Pendente");
    }
}