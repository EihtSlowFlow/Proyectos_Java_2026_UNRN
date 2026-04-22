package ar.unrn.tp4.ejercicio3.persistencia;

import ar.unrn.tp4.ejercicio3.modelo.Concurso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    String path;

    public LectorArchivo(String path) {
        this.path = path;
    }

    public List<Concurso> todosLosConcursos() {
        List<Concurso> lineas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        /// Construcción de la lista
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine(); // Ayudar a saltarse la cabecera. Antes tiraba error porque leía el String de IdConcurso en lugar del numero "debajo"
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    int idconcurso = Integer.parseInt(partes[0]);
                    String nombre = partes[1].trim();
                    LocalDate fechaInicioInscripcion = LocalDate.parse(partes[2].trim(), formatter);
                    LocalDate fechaFinInscripcion = LocalDate.parse(partes[3].trim(), formatter);
                    Concurso concurso = new Concurso(idconcurso, nombre, fechaInicioInscripcion, fechaFinInscripcion);
                    lineas.add(concurso);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo: " + path, e);
        }
        return lineas;
    }

}
