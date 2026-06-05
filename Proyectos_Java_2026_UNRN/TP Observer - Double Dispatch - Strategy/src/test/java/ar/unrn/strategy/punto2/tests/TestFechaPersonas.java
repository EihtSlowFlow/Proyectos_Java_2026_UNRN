package ar.unrn.strategy.punto2.tests;

import org.junit.Test;
import ar.unrn.strategy.punto2.*;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

public class TestFechaPersonas {

    @Test
    public void testPersonaConFechaCorta() {

        LocalDate fechaNacimiento = LocalDate.of(2000, 1, 1);
        Persona juan = new Persona(fechaNacimiento, new FechaCorta());


        String resultadoObtenido = juan.fechaNacimiento();


        assertEquals("1-1-2000", resultadoObtenido);
    }

    @Test
    public void testPersonaConFechaLarga() {

        LocalDate fechaNacimiento = LocalDate.of(2000, 1, 1);
        Persona juan = new Persona(fechaNacimiento, new FechaLarga());


        String resultadoObtenido = juan.fechaNacimiento();


        assertEquals("1 de enero de 2000", resultadoObtenido);
    }
}