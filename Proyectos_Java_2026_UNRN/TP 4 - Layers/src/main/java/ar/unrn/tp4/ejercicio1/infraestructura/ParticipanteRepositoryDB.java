package ar.unrn.tp4.ejercicio1.infraestructura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp4.ejercicio1.dominio.ParticipanteRepository;
import ar.unrn.tp4.ejercicio1.dominio.Participante;

public class ParticipanteRepositoryDB implements ParticipanteRepository {

    private final Connection conn;

    public ParticipanteRepositoryDB(Connection conn) {
        this.conn = conn;
    }


    public void guardar(Participante participante) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "insert into participantes(nombre, telefono, region) values(?,?,?)"
            );

            try {
                st.setString(1, participante.nombre());
                st.setString(2, participante.telefono());
                st.setString(3, participante.region());
                st.executeUpdate();
            } finally {
                st.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}