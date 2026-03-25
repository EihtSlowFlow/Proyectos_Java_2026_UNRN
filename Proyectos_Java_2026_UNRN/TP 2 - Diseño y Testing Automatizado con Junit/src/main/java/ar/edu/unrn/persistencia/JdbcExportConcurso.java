package ar.edu.unrn.persistencia;

import ar.edu.unrn.modelo.Punto1.Export;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcExportConcurso implements Export {

    public JdbcExportConcurso() {
    }

    @Override
    public void exportar(String datosCSV) {
        String[] lineas = datosCSV.split(System.lineSeparator());
        String sql = "INSERT INTO inscripciones_concursos (fecha_inscripcion, participante_dni, nombre_concurso) VALUES (?, ?, ?)";

        // Pedimos la conexión al manager centralizado
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (int i = 1; i < lineas.length; i++) {
                if (lineas[i].isBlank()) continue;

                String[] columnas = lineas[i].split(",");
                pstmt.setString(1, columnas[0].trim()); // fecha_inscripcion (String)
                pstmt.setLong(2, Long.parseLong(columnas[1].trim())); // dni_participante (Número largo)
                pstmt.setString(3, columnas[2].trim()); // nombre_concurso (Texto)

                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();
            System.out.println("Carga completada con éxito en la DB.");

        } catch (SQLException e) {
            throw new RuntimeException("Error en la persistencia JDBC: " + e.getMessage(), e);
        }
    }

}
