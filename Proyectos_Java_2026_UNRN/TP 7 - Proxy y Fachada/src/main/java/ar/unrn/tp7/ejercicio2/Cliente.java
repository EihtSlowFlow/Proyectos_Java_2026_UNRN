package ar.unrn.tp7.ejercicio2;



import java.io.IOException;

public class Cliente {


    public static final String FILE_ADV = "No se pudo leer el archivo físico: ";
    private FileAccessInterface fileAccess;
    private Usuario usuario;
    private String path;
    private String nombreArchivo;

    public Cliente(String path, String nombreArchivo, Usuario usuario) {
        this.path = path;
        this.nombreArchivo = nombreArchivo;
        this.usuario = usuario;
        this.fileAccess = new ProcesadorDeTexto(path, nombreArchivo, usuario);
    }

    public void leerArchivo() {
        try {
            String contenido = this.fileAccess.readFile();
            System.out.println("Contenido de '" + nombreArchivo + "':\n" + contenido);
        } catch (SecurityException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(FILE_ADV + e.getMessage());
        }
    }

}
