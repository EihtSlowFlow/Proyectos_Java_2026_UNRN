package ar.unrn.tp4.ejercicio3.persistencia;

import ar.unrn.tp4.ejercicio3.modelo.Candidato;
import ar.unrn.tp4.ejercicio3.modelo.OutExport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EscritorJDBC implements OutExport {
    private final String url;
    private final String user;
    private final String password;

    public EscritorJDBC(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void saveInscription(String apellido, String nombre, String telefono, String email, int idConcurso) {
        String sql = "INSERT INTO inscriptos (nombre, apellido, telefono, email, id_concurso) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, telefono);
            pstmt.setString(4, email);
            pstmt.setInt(5, idConcurso);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error de base de datos al guardar la inscripción", e);
        }
    }
}