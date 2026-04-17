package ar.edu.unrn.modelo.Punto1;

import ar.edu.unrn.infraestructura.Notificador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Concurso {
    private final Export export;
    private final String nombreConcurso;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final List<Participante> inscriptos;
    /// Inyección de dependencia
    private final Supplier<LocalDate> dateProvider;
    /// Notificador, puede llamar al que está en memoria o al que está enlazado a mailtrap
    private final Notificador notificador;


    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Concurso(LocalDate inicio, LocalDate fin, String nombreConcurso, Export export, Notificador notificacion, Supplier<LocalDate> dateProvider) {
        this.nombreConcurso = nombreConcurso;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.inscriptos = new ArrayList<>();
        this.dateProvider = dateProvider; // Por defecto es hoy
        this.export = export;
        this.notificador = notificacion;
    }

    public boolean estaAbierto() {
        // Rango inclusivo: inicio <= actual <= fin
        LocalDate hoy = dateProvider.get();
        return (hoy.isEqual(fechaInicio) || hoy.isAfter(fechaInicio)) &&
                (hoy.isEqual(fechaFin) || hoy.isBefore(fechaFin));
    }

    public void inscribirParticipante(Participante p) {
        if (!estaAbierto()) {
            throw new RuntimeException("El concurso ya no está abierto para inscripciones.");
        }

        if (dateProvider.get().isEqual(fechaInicio)) {
            p.ganarPuntos(10);
        }
        this.inscriptos.add(p);
/*
        // UN SOLO FORMATO: El que pide la consigna y el test
        // dd/mm/yyyy, id_participante, id_concurso
        String linea = String.format("%s, %d, %s",
                this.fechaActual.format(FORMATO_FECHA),
                p.getDni(),
                this.nombreConcurso);

        export();

 */

        notificador.enviarNotificacion(p.getCorreoElectronico(),
                "Inscripción al concurso " + this.nombreConcurso,
                "¡Hola " + p.getNombreCompleto() + "! \nLe comunicamos desde la administración superior de gerencia administrativa con sede en la jefatura marcial correctiva interdisciplinaria y autorreflexiva que usted ha sido aceptado en el concurso de " + this.nombreConcurso + ".\n" +
                        "Fecha de inscripción: " + this.dateProvider.get().format(FORMATO_FECHA) + "\n" +
                        "¡Muchas felicidades! ");
    }

    public void export() {
        this.export.exportar(toCSV());
    }

    public String toCSV() {
        StringBuilder sb = new StringBuilder(); // Quitamos el salto de línea inicial
        sb.append("Fecha, DNI, NombreDelConcurso, CorreoElectronico").append(System.lineSeparator());
        for (Participante p : inscriptos) {
            // Quitamos la coma final después de %s
            sb.append(String.format("%s, %d, %s, %s%n",
                    this.dateProvider.get().format(FORMATO_FECHA), p.getDni(), this.nombreConcurso, p.getCorreoElectronico()));
        }
        return sb.toString();
    }
    /* De plano, está mal. Rompe encapsulamiento.
    // Método fundamental para los tests
    public void setFechaActual(LocalDate fecha) {
        this.fechaActual = fecha;
    }
     */

    /// Funciona correctamente, se sobrescribieron los métodos equals y hashcode sobre la clase Participante.
    public boolean tieneInscripto(Participante p) {
        return inscriptos.contains(p);
    }
}