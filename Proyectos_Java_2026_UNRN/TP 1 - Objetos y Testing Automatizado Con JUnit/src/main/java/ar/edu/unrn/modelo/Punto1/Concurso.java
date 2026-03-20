package ar.edu.unrn.modelo.Punto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private LocalDate fechaActual; // Para simular el paso del tiempo en tests
    private final List<Participante> inscriptos;

    public Concurso(LocalDate inicio, LocalDate fin) {
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.inscriptos = new ArrayList<>();
        this.fechaActual = LocalDate.now(); // Por defecto es hoy
    }

    public boolean estaAbierto() {
        // Rango inclusivo: inicio <= actual <= fin
        return (fechaActual.isEqual(fechaInicio) || fechaActual.isAfter(fechaInicio)) &&
                (fechaActual.isEqual(fechaFin) || fechaActual.isBefore(fechaFin));
    }

    public void inscribirParticipante(Participante p) {
        if (!estaAbierto()) {
            throw new RuntimeException("El concurso ya no está abierto para inscripciones.");
        }

        // Regla: 10 puntos solo el primer día
        if (fechaActual.isEqual(fechaInicio)) {
            p.ganarPuntos(10);
        }

        this.inscriptos.add(p);
    }

    // Método fundamental para los tests
    public void setFechaActual(LocalDate fecha) {
        this.fechaActual = fecha;
    }

    public boolean tieneInscripto(Participante p) {
        return inscriptos.contains(p);
    }
}