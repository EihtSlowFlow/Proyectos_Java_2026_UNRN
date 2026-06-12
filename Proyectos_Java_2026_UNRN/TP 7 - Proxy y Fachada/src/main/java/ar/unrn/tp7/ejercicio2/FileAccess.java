package ar.unrn.tp7.ejercicio2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class    FileAccess implements FileAccessInterface {
    private String ruta;
    private String nombreArchivo;

    public FileAccess(String ruta, String nombre) {
        this.ruta = ruta;
        this.nombreArchivo = nombre;
    }

    public String readFile() throws SecurityException, IOException {
        if(ruta == null){
            throw new IOException("La ruta no puede ser nula.");
        }
        return Files.readString(Paths.get(this.ruta + "/" + this.nombreArchivo));
    }
    public boolean comienzaCon(String letra) {
        return this.nombreArchivo.startsWith(letra);
    }
}
