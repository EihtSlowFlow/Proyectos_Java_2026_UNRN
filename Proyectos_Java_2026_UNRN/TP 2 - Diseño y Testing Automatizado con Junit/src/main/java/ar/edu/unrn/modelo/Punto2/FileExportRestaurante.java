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
        try (FileWriter writer = new FileWriter(file, true)) { // Append mode
            writer.write(data + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar los datos: " + e.getMessage());
        }
    }
}
