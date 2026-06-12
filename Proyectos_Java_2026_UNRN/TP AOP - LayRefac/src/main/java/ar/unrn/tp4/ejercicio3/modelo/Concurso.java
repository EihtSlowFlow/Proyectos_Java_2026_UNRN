package ar.unrn.tp4.ejercicio3.modelo;

import java.time.LocalDate;

// Prestar atención a la "obsesión con los primitivos"
public class Concurso {
    public static final String MENSAJE_CONCURSO_INVALIDO = "Debes seleccionar un concurso valido";
    private int idconcurso;
    private final String nombre;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;

    public Concurso(int idconcurso, String nombre, LocalDate fechaInicioInscripcion,
                    LocalDate fechaFinInscripcion) {
        if (esMiIDValido(idconcurso)) {
            this.idconcurso = idconcurso;
        }
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public int Idconcurso() {
        return idconcurso;
    }

    public boolean estaAbierto() {
        LocalDate hoy = LocalDate.now();
        return (hoy.isEqual(fechaInicioInscripcion) || hoy.isAfter(fechaInicioInscripcion)) &&
                (hoy.isEqual(fechaFinInscripcion) || hoy.isBefore(fechaFinInscripcion));
    }

    public String toString() {
        /// Se sobrescribio así para que en la vista se pueda ver solo el nombre y no THODO el detalle en la vista.
        return nombre;
    }

    public boolean esMiIDValido(int idConcursoExterno) {
        if (idConcursoExterno <= 0) {
            throw new IllegalArgumentException(MENSAJE_CONCURSO_INVALIDO);
        }
        return true;
    }
}
