package ar.unrn.tp4.ejercicio3.persistencia;

import ar.unrn.tp4.ejercicio3.modelo.OutExport;

import java.io.*;

public class EscritorArchivo implements OutExport {
    String path;

    public EscritorArchivo(String path) {
        this.path = path;
    }
    
    @Override
    // Acá pongo el LOG
    @Log
    public void saveInscription(String apellido, String nombre, String telefono, String email, int idConcurso) {
        String linea = apellido + "," + nombre + "," + telefono + "," + email + "," + idConcurso;
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(linea); // println agrega el salto de línea automático
        } catch (IOException e) {
            throw new RuntimeException("Error guardando en: " + path, e);
        }
    }


}
