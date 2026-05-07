package com.project.demo.classes;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String emailFuncionario;

    public Funcionario(String nomeCompleto, LocalDate dataNascimento, String telefone, int idFuncionario) {
        super(nomeCompleto, dataNascimento, telefone);

        setIdFuncionario(idFuncionario);
        this.emailFuncionario = idFuncionario + "@biblioteca.com";
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        if (idFuncionario <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        this.idFuncionario = idFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    @Override
    public String getTipo() {
        return "Funcionário";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: " + getTipo() +
                "\nID Funcional: " + idFuncionario +
                "\nEmail: " + emailFuncionario;
    }
}