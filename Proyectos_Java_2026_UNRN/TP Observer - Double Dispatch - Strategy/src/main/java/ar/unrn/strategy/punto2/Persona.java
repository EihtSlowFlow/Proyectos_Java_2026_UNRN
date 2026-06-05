package ar.unrn.strategy.punto2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    LocalDate fechaNacimiento;
    FormatoFechaNac formatter;
   // DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Persona(LocalDate fechaNacimiento, FormatoFechaNac formatter) {
        this.fechaNacimiento = fechaNacimiento;
        this.formatter = formatter;
    }

    public String fechaNacimiento() {
        return formatter.formatearFecha(fechaNacimiento);
    }


}
