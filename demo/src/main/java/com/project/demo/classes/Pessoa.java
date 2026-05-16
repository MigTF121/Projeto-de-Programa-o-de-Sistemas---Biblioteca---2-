package com.project.demo.classes;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    // Novas adições para integração com Spring Data JPA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String telefone;

    public Pessoa() {}

    //

    public Pessoa(String nomeCompleto, LocalDate dataNascimento, String telefone) {
        setNomeCompleto(nomeCompleto);
        setDataNascimento(dataNascimento);
        setTelefone(telefone);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data inválida.");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = telefone;
    }

    public String getTipo() {
        return "Pessoa";
    }

    @Override
    public String toString() {
        return "Nome: " + nomeCompleto +
            "\nData de nascimento: " + dataNascimento +
            "\nTelefone: " + telefone;
    }
}