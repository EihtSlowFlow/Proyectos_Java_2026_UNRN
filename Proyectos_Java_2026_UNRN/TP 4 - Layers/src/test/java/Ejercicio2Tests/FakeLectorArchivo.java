package Ejercicio2Tests;

public class FakeLectorArchivo {
    private final String rutaArchivo;

    public FakeLectorArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String leerArchivo() {
        // Simula la lectura de un archivo y devuelve un contenido predefinido
        return "Nombre,Apellido,Email\n" +
                "Juan,Perez,juanceto07@gmail.com";
    }
}
