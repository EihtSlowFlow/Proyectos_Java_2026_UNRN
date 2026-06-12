package ar.unrn.tp7.ejercicio1;
import java.util.Set;

public class Persona {
    private int id;
    private String nombre;
    // Set --> sujeto real
    // proxy --> implementa al sujeto real, Set
    // telefono --> sujeto
   /// private Set<Telefono> telefonos;

   private Set<Telefono> telefonos;

    public Persona(int id, String nombre, Set<Telefono> telefonos) {
        this.id = id;
        this.nombre = nombre;
        this.telefonos = telefonos;
    }
    // El proxy debe implementar los métodos que el sujeto efectivamente va a utilizar
    public Telefono[] telefonos() {
        return telefonos.toArray(new Telefono[telefonos.size()]);
    }

    public String nombre() {
        return nombre;
    }
}