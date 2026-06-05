package ar.unrn.observer.ejercicio4.main;


import ar.unrn.observer.ejercicio4.dominio.CrearParticipante;
import ar.unrn.observer.ejercicio4.dominio.ObservadorEmail;import ar.unrn.observer.ejercicio4.dominio.Observer;
import ar.unrn.observer.ejercicio4.infraestructura.ParticipanteRepositoryDB;
import ar.unrn.observer.ejercicio4.ui.AgregarParticipanteUI;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

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
                Observer observador = new ObservadorEmail();
                casoUso.addObserver(observador);

                new AgregarParticipanteUI(casoUso);


            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}