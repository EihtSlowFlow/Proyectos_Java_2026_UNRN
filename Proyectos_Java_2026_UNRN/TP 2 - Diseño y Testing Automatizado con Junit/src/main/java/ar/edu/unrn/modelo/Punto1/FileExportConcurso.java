package ar.edu.unrn.modelo.Punto1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileExportConcurso implements Export {
    private final String path;

    public FileExportConcurso(String path) {
        this.path = path;
    }


    @Override
    public void exportar(String datos) {
        File aFile = new File(path);
        try (FileWriter writer = new FileWriter((aFile), true)) { // --> Append true, para que
            // no borre lo anterior cada vez que se llama al método en la dirección estipulada
            writer.write(datos + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar los datos: " + e.getMessage(), e);
        }
    }

}
