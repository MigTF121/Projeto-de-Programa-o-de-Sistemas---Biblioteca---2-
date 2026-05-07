package com.project.demo.classes;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario extends Pessoa {
    private int registroUsuario;
    private String emailUsuario;
    private ArrayList<Exemplar> livrosEmprestados;

    public static final int LIMITE_LIVROS = 3;

    public Usuario(String nomeCompleto, LocalDate dataNascimento, String telefone, int registroUsuario) {
        super(nomeCompleto, dataNascimento, telefone);

        setRegistroUsuario(registroUsuario);
        this.emailUsuario = registroUsuario + "@biblioteca.com";
        this.livrosEmprestados = new ArrayList<>();
    }

    public int getRegistroUsuario() {
        return registroUsuario;
    }

    public void setRegistroUsuario(int registroUsuario) {
        if (registroUsuario <= 0) {
            throw new IllegalArgumentException("Registro inválido.");
        }
        this.registroUsuario = registroUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public boolean podeEmprestar() {
        return livrosEmprestados.size() < LIMITE_LIVROS;
    }

    public void adicionarLivroEmprestado(Exemplar exemplar) {
        if (!podeEmprestar()) {
            throw new IllegalArgumentException("Usuário já atingiu o limite de livros.");
        }
        livrosEmprestados.add(exemplar);
    }

    public void removerLivroEmprestado(Exemplar exemplar) {
        livrosEmprestados.remove(exemplar);
    }

    public int getQuantidadeLivrosEmprestados() {
        return livrosEmprestados.size();
    }

    public ArrayList<Exemplar> getLivrosEmprestados() {
        return new ArrayList<>(livrosEmprestados);
    }

    @Override
    public String getTipo() {
        return "Usuário";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRegistro: " + registroUsuario +
                "\nEmail: " + emailUsuario +
                "\nLivros emprestados: " + livrosEmprestados.size();
    }
}