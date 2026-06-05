package ar.unrn.observer.ejercicio4.infraestructura;
import ar.unrn.observer.ejercicio4.dominio.Participante;
import ar.unrn.observer.ejercicio4.dominio.ParticipanteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteRepositoryDB implements ParticipanteRepository {

    private final Connection conn;

    public ParticipanteRepositoryDB(Connection conn) {
        this.conn = conn;
    }


    public void guardar(Participante participante) {
        try {

            try (PreparedStatement st = conn.prepareStatement(
                    "insert into participantes(nombre, telefono, region) values(?,?,?)"
            )) {
                st.setString(1, participante.nombre());
                st.setString(2, participante.telefono());
                st.setString(3, participante.region());
                st.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}