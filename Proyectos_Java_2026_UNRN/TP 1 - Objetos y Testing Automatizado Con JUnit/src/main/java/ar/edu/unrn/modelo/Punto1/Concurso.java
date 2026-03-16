package ar.edu.unrn.modelo.Punto1;

import java.util.Calendar;

public class Concurso {
    private final Calendar dia_de_inscripcion = Calendar.getInstance();
    private final Calendar ultimoDiaDeinscripcion = Calendar.getInstance();

    private Calendar fechaActual = Calendar.getInstance();

    public Concurso() {
        dia_de_inscripcion.set(2024, Calendar.JUNE, 20);
        ultimoDiaDeinscripcion.set(2024, Calendar.JUNE, 27);
        /// fechaActual.set(anio, mes, dia);
    }

    public boolean estaAbierto() {
        return (fechaActual.after(dia_de_inscripcion) && fechaActual.before(ultimoDiaDeinscripcion)) ||
                fechaActual.equals(dia_de_inscripcion) || fechaActual.equals(ultimoDiaDeinscripcion);
    }

    public void inscribirParticipante(Participante participante) {
        ///  Dia en el que se está inscribiendo el participante
        if (!estaAbierto()) {
            throw new RuntimeException("El concurso ya no está abierto para inscripciones.");
        } else {
            if (fechaActual.equals(dia_de_inscripcion)) {
                participante.ganarPuntos(10);
                ///  Ahora el ultimo dia entra como tiempo de inscripcion, pero no da puntos extra.
            } else if (fechaActual.after(dia_de_inscripcion) && (fechaActual.before(ultimoDiaDeinscripcion) || fechaActual.equals(ultimoDiaDeinscripcion))) {
                System.out.println("Participante inscrito sin puntos adicionales.");
            }
            // Lógica para inscribir al participante
        }
    }

    // Método para establecer la fecha actual para testing
    public void setFechaActual(Calendar fecha) {
        this.fechaActual = fecha;
    }
}
