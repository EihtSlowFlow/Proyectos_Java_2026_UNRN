package ar.edu.unrn.persistencia;

import ar.edu.unrn.modelo.Punto2.Export;

import java.sql.*;

public class JdbcExportRestaurante implements Export {
    public JdbcExportRestaurante() {
    }

    @Override
    public void exportar(String datosCSV) {
        String[] lineas = datosCSV.split(System.lineSeparator());
        String sql = "INSERT INTO ventas_restaurante (fecha_hora, total_pedido) VALUES (?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (int i = 0; i < lineas.length; i++) {
                if (lineas[i].isBlank()) continue;

                String[] columnas = lineas[i].split("\\|\\|");

                pstmt.setString(1, columnas[0].trim());
                pstmt.setDouble(2, Double.parseDouble(columnas[1].trim().replace(",", ".")));

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