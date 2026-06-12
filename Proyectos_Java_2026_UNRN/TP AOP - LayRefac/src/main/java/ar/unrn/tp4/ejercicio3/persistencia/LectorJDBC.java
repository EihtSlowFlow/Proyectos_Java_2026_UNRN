package ar.unrn.tp4.ejercicio3.persistencia;

import ar.unrn.tp4.ejercicio3.modelo.CompetitionManagement;
import ar.unrn.tp4.ejercicio3.modelo.Concurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorJDBC implements CompetitionManagement {
    private final String url;
    private final String user;
    private final String password;

    public LectorJDBC(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Concurso> todosLosConcursos() {
        String sql = "SELECT id_concurso, nombre, fecha_inicio, fecha_fin FROM concursos";
        List<Concurso> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Concurso c = new Concurso(
                        rs.getInt("id_concurso"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al cargar los concursos desde la Base de Datos", e);
        }

        return lista;
    }
}