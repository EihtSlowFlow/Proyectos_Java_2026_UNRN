package ar.unrn.tp4.ejercicio3.main;

import ar.unrn.tp4.ejercicio3.modelo.CompetitionManagement;
import ar.unrn.tp4.ejercicio3.modelo.InscriptionManagement;
import ar.unrn.tp4.ejercicio3.modelo.InscriptionManager;
import ar.unrn.tp4.ejercicio3.modelo.OutExport;
import ar.unrn.tp4.ejercicio3.persistencia.EscritorJDBC;
import ar.unrn.tp4.ejercicio3.persistencia.LectorJDBC;
import ar.unrn.tp4.ejercicio3.vista.Layout;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainBD {
    public static void main(String[] args) {

        Properties props = new Properties();

        try (InputStream input = MainBD.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("No se encontró config.properties en la carpeta resources.");
            }

            props.load(input);

        } catch (IOException ex) {
            throw new RuntimeException("Error al cargar config.properties. Verifica que el archivo exista.", ex);
        }

        // Extraemos las credenciales
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");

        // Ensamblamos la aplicación
        OutExport exportador = new EscritorJDBC(url, user, pass);
        CompetitionManagement lector = new LectorJDBC(url, user, pass);

        InscriptionManagement manager = new InscriptionManager(exportador);

        new Layout(lector, manager);
    }
}