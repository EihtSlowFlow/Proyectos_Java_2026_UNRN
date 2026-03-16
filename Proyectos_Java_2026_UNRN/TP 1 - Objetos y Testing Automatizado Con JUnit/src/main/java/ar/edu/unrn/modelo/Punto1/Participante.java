package ar.edu.unrn.modelo.Punto1;

public class Participante {
    private final String nombre;
    private final int edad;
    private final String apellido;
    private final int DNI;
    private int puntos = 0;


    public Participante(String nombre, String apellido, int edad, int DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
        ///  Corrección tras clase, lógica de negocio de constructor.
        if (this.edad < 18) {
            throw new RuntimeException("El participante debe ser mayor de edad para inscribirse.");
        }
    }

    public void ganarPuntos(int puntosGanados) {
        if (puntosGanados >= 0)
            this.puntos += puntosGanados;
    }


    public void inscribirseA(Concurso concurso) {
        concurso.inscribirParticipante(this);
    }

    private int getEdad() {
        return edad;
    }

    private void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

}
