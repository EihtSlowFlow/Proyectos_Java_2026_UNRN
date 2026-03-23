package ar.edu.unrn.modelo.Punto2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExportRestaurante implements Export {
    private final String filePath;

    public FileExportRestaurante(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void exportar(String data) {
        File file = new File(filePath);
        boolean archivoNuevo = !file.exists(); // Comprueba existencia del archivo.

        try (FileWriter writer = new FileWriter(file, true)) {
            // Si el archivo es nuevo, podrías escribir el encabezado aquí
            // o dejar que el méto-do toCSV lo maneje to-do junto.
            writer.write(data + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error en disco: " + e.getMessage());
        }
    }
}
