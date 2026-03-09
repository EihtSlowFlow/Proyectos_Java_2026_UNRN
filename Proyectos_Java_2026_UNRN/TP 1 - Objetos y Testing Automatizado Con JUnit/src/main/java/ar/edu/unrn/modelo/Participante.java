package ar.edu.unrn.modelo;

public class Participante {
    private final String nombre;
    private final int edad;
    private final String apellido;
    private final int DNI;
    private int puntos;

    public Participante(String nombre, String apellido, int edad, int DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

}
