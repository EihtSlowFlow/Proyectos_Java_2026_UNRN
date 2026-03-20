package ar.edu.unrn.modelo.Punto1;

public class Participante {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final int dni;
    private int puntos;

    public Participante(String nombre, String apellido, int edad, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.puntos = 0;
    }

    public void ganarPuntos(int cantidad) {
        if (cantidad > 0) {
            this.puntos += cantidad;
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public void inscribirseA(Concurso concurso) {
        concurso.inscribirParticipante(this);
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}