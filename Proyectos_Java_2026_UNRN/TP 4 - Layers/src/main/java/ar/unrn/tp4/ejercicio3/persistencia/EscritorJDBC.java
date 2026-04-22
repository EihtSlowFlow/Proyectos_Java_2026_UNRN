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
    public void saveInscription(Candidato ca) {
        String sql = "INSERT INTO inscriptos (nombre, apellido, telefono, email, id_concurso) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ca.nombre());
            pstmt.setString(2, ca.apellido());
            pstmt.setString(3, ca.telefono());
            pstmt.setString(4, ca.email());
            pstmt.setInt(5, ca.idconcurso());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error de base de datos al guardar la inscripción", e);
        }
    }
}