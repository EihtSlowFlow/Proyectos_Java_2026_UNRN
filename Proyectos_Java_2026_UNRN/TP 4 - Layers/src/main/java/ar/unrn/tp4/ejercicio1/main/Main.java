package ar.unrn.tp4.ejercicio1.main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import ar.unrn.tp4.ejercicio1.dominio.CrearParticipante;
import ar.unrn.tp4.ejercicio1.infraestructura.ParticipanteRepositoryDB;
import ar.unrn.tp4.ejercicio1.ui.AgregarParticipanteUI;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/participantes?createDatabaseIfNotExist=true",
                        "app",
                        "app"
                );

                var repo = new ParticipanteRepositoryDB(conn);
                var casoUso = new CrearParticipante(repo);

                new AgregarParticipanteUI(casoUso);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}