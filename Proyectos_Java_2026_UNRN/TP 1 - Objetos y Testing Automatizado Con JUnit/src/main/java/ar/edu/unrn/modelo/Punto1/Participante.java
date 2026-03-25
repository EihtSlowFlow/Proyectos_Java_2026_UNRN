package ar.edu.unrn.modelo.Punto1;

import java.util.Objects;

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
        this.puntos += cantidad;
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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return dni == that.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

}