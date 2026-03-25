package ar.edu.unrn.modelo.Punto1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileExportConcurso implements Export {
    private final String path;

    public FileExportConcurso(String path) {
        this.path = path;
    }

    @Override
    public void exportar(String datosEntrada) {
        File archivo = new File(this.path);
        boolean yaTieneContenido = archivo.exists() && archivo.length() > 0;

        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
            String[] lineas = datosEntrada.split(System.lineSeparator());

            // Si el archivo ya tiene datos, ignoramos la primera línea del string. Para evitar tener un doble encabezado.
            int i = yaTieneContenido ? 1 : 0;

            for (; i < lineas.length; i++) {
                writer.println(lineas[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar a archivo", e);
        }
    }
}
