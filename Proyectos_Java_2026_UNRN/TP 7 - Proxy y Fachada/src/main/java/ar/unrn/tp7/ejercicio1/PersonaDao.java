package ar.unrn.tp7.ejercicio1;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {

    private Connection obtenerConexion() {
        String url = "jdbc:mysql://localhost:3306/TP7";
        String user = "root";
        String password = "Ramiro_2026!";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    public Persona personaPorId(int id) {
        String sql = "select p.nombre "
                + "from personas p "
                + "where p.id = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Set<Telefono> telefonos = new ProxyTelefono(id, this); // Inicialización diferida, el proxy se encargará de cargar los telefonos cuando se llame a persona.telefonos().

            String nombrePersona = null;

            while (result.next()) {
                nombrePersona = result.getString(1);
            ///    telefonos.add(new Telefono(result.getString(2)));
            }
            // Acá lo devuelvo, con inicialización diferida se espera que solamente se popule cuando se llame al
            // METHOD  persona.telefonos(). Cosa que ocurre en el main, no acá.
            /// Como lo implementé, la persona tiene un proxy, y el proxy se encarga de cargar los telefonos cuando se llama a persona.telefonos().
            return new Persona(id, nombrePersona, telefonos);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    Set<Telefono> telefonosPorID(int id) {
        String sql = "select t.numero "
                + "from telefonos t "
                + "where t.persona_id = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Set<Telefono> telefonos = new HashSet<>();

            while (result.next()) {
                telefonos.add(new Telefono(result.getString(1)));
            }

            return telefonos;

        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar los teléfonos", e);
        }
    }


}