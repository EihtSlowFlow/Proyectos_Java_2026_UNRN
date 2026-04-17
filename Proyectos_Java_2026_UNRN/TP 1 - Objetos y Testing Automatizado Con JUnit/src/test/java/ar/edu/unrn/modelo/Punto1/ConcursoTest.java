package ar.edu.unrn.modelo.Punto1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    private Concurso concurso;
    private Participante participante;
    private final LocalDate INICIO = LocalDate.of(2026, 3, 20);
    private final LocalDate FIN = LocalDate.of(2026, 3, 27);

    @BeforeEach
    void setUp() {
        concurso = new Concurso(INICIO, FIN);
        participante = new Participante("Ramiro", "García", 25, 12345678);
    }

    @Test
    public void testInscripcionPrimerDiaGana10Puntos() {
        concurso.setFechaActual(INICIO); // Uso de setter.
        participante.inscribirseA(concurso);

        assertEquals(10, participante.getPuntos(), "Debe ganar 10 puntos en el día 1");
        assertTrue(concurso.tieneInscripto(participante));
    }

    @Test
    public void testInscripcionDiaIntermedioNoGanaPuntos() {
        // Un día después del inicio
        concurso.setFechaActual(INICIO.plusDays(1));
        participante.inscribirseA(concurso);

        assertEquals(0, participante.getPuntos(), "No debe ganar puntos extras");
        assertTrue(concurso.tieneInscripto(participante));
    }

    @Test
    public void testInscripcionUltimoDiaEsExitosa() {
        concurso.setFechaActual(FIN); // Uso de setter.
        participante.inscribirseA(concurso);

        assertTrue(concurso.estaAbierto());
        assertTrue(concurso.tieneInscripto(participante));
        assertEquals(0, participante.getPuntos());
    }

    @Test
    public void testInscripcionAntesDeFechaLanzaExcepcion() {
        concurso.setFechaActual(INICIO.minusDays(1));

        assertFalse(concurso.estaAbierto());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            participante.inscribirseA(concurso);
        });
        assertEquals("El concurso ya no está abierto para inscripciones.", ex.getMessage());
    }

    @Test
    public void testInscripcionDespuesDeFechaLanzaExcepcion() {
        concurso.setFechaActual(FIN.plusDays(1));

        assertThrows(RuntimeException.class, () -> participante.inscribirseA(concurso));
    }

    @Test
    public void testCoberturaMetodosParticipante() {
        assertEquals("Ramiro García", participante.getNombreCompleto());
        participante.ganarPuntos(-5);
        assertEquals(0, participante.getPuntos());
    }
}