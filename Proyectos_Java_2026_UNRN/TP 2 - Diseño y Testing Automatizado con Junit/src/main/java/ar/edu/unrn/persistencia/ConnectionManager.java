package ar.edu.unrn.persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConnectionManager.class.getClassLoader()
                .getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo database.properties");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar la configuración de la DB", e);
        }
    }

    public static Connection getConnection() throws java.sql.SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}
