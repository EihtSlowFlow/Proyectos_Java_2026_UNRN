package ar.unrn.tp4.ejercicio3.modelo;

import java.time.LocalDate;

public record Concurso(int idconcurso, String nombre, LocalDate fechaInicioInscripcion,
                       LocalDate fechaFinInscripcion) {
    public boolean estaAbierto() {
        LocalDate hoy = LocalDate.now();
        return (hoy.isEqual(fechaInicioInscripcion) || hoy.isAfter(fechaInicioInscripcion)) &&
                (hoy.isEqual(fechaFinInscripcion) || hoy.isBefore(fechaFinInscripcion));
    }

    public String toString() {
        return this.nombre;
    }
}
