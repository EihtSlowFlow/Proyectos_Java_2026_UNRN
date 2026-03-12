package ar.edu.unrn.modelo.punto1;

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
            if (participante.getEdad() < 18) {
                throw new RuntimeException("El participante debe ser mayor de edad para inscribirse.");
            } else if (fechaActual.equals(dia_de_inscripcion)) {
                int puntos = participante.getPuntos();
                puntos += 10; // Asignar puntos por inscribirse el día de la inscripción
                participante.setPuntos(puntos);
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
