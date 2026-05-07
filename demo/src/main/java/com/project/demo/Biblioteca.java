package com.project.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Biblioteca {
    private PreparedStatement createStmt;
    private  PreparedStatement readStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement deleteStmt;

    public Biblioteca (Connection conn)  throws SQLException{

        createStmt = conn.prepareStatement("INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)");
        readStmt = conn.prepareStatement("SELECT * FROM livros WHERE id = ?");
        updateStmt = conn.prepareStatement("UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?");
        deleteStmt = conn.prepareStatement("DELETE FROM livros WHERE id = ?");
    }

    public void createLivro(String titulo, String autor, int anoPublicacao) throws SQLException {
        createStmt.setString(1, titulo);
        createStmt.setString(2, autor);
        createStmt.setInt(3, anoPublicacao);
        createStmt.executeUpdate();
    }

    public void readLivro(int id) throws SQLException {
        readStmt.setInt(1, id);
        readStmt.executeQuery();
    }

    public void updateLivro(int id, String titulo, String autor, int anoPublicacao) throws SQLException {
        updateStmt.setString(1, titulo);
        updateStmt.setString(2, autor);
        updateStmt.setInt(3, anoPublicacao);
        updateStmt.setInt(4, id);
        updateStmt.executeUpdate();
    }

    public void deleteLivro(int id) throws SQLException {
        deleteStmt.setInt(1, id);
        deleteStmt.executeUpdate();
    }

}
