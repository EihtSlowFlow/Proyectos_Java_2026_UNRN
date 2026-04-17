package ar.unrn.tp4.ejercicio2.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import java.time.format.DateTimeFormatter;

import ar.unrn.tp4.ejercicio2.modelo.Empleado;
import ar.unrn.tp4.ejercicio2.modelo.ExportProvider;

public class FileManager implements ExportProvider {
    private final String rutaArchivo;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy/M/d");

    public FileManager(String ruta) {
        this.rutaArchivo = ruta;
    }
    
    @Override
    public List<Empleado> obtenerEmpleados() {
        try (Stream<String> lineas = Files.lines(Paths.get(rutaArchivo))) {
            return lineas.skip(1) // Ignora la cabecera: "apellido, nombre, fecha de nacimiento, email"
                    .map(linea -> linea.split(","))
                    .filter(partes -> partes.length == 4) // Verifica que la línea sea válida
                    .map(partes -> new Empleado(
                            partes[0].trim(), // apellido
                            partes[1].trim(), // nombre
                            //LocalDate.parse(partes[2].trim()), // fecha de nacimiento (ISO 2026-04-16)
                            LocalDate.parse(partes[2].trim(), FORMATO_FECHA),
                            partes[3].trim()  // email
                    ))
                    .toList(); // Disponible desde Java 16+
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de empleados", e);
        }
    }
}
