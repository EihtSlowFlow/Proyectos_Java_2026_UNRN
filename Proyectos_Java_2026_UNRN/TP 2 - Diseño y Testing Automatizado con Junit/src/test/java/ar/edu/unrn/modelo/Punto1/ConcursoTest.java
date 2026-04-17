package ar.edu.unrn.modelo.Punto1;

import ar.edu.unrn.infraestructura.Notificador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    private Concurso concurso;
    private Participante participante;
    private Notificador noti;

    private final LocalDate INICIO = LocalDate.of(2026, 3, 20);
    private final LocalDate FIN = LocalDate.of(2026, 3, 27);
    private LocalDate RELOJTEST;

    @BeforeEach
    void setUp() {
        noti = new MockEmailService();
        RELOJTEST = INICIO;
        concurso = new Concurso(INICIO, FIN, "Concurso de Programación", new FileExportConcurso("/home/ramiro/tp2-punto1-participantesExportados.txt"), noti, () -> this.RELOJTEST);
    }

    @Test
    public void testInscripcionPrimerDiaGana10Puntos() {
        this.RELOJTEST = INICIO;
        participante = new Participante("Barney", "Gomez", 40, 12345678, "CERBESAAA@yahoo.com");

        participante.inscribirseA(concurso);

        assertEquals(10, participante.getPuntos(), "Debe ganar 10 puntos en el día 1");
        assertTrue(concurso.tieneInscripto(participante));
    }

    @Test
    public void testInscripcionDiaIntermedioNoGanaPuntos() {
        this.RELOJTEST = INICIO.plusDays(3);
        participante = new Participante("Barney", "Gomez", 40, 12345678, "CERBESAAA@yahoo.com");

        participante.inscribirseA(concurso);

        assertEquals(0, participante.getPuntos(), "No debe ganar puntos extras");
        assertTrue(concurso.tieneInscripto(participante));
    }

    @Test
    public void testInscripcionUltimoDiaEsExitosa() {
        this.RELOJTEST = FIN;
        participante = new Participante("Bart", "Simpson", 42, 12344668, "AyKaramba1978@gmail.com");
        participante.inscribirseA(concurso);

        assertTrue(concurso.estaAbierto());
        assertTrue(concurso.tieneInscripto(participante));
        assertEquals(0, participante.getPuntos());
    }

    @Test
    public void testInscripcionAntesDeFechaLanzaExcepcion() {
        this.RELOJTEST = INICIO.minusDays(2);
        participante = new Participante("Nelson", "Muntz", 11, 44451200, "HaHa123123@gmail.com");

        assertFalse(concurso.estaAbierto());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> participante.inscribirseA(concurso));
        assertEquals("El concurso ya no está abierto para inscripciones.", ex.getMessage());
    }

    @Test
    public void testInscripcionDespuesDeFechaLanzaExcepcion() {
        this.RELOJTEST = FIN.plusDays(1);
        participante = new Participante("Rafa", "Gorgory", 10, 11135887, "kesesodecorreoasdasd@gmail.com");

        assertThrows(RuntimeException.class, () -> participante.inscribirseA(concurso));
    }

    @Test
    public void testCoberturaMetodosParticipante() {
        participante = new Participante("Ramiro", "García", 20, 12345678, "ramiro.garcia@gmail.com");

        assertEquals("Ramiro García", participante.getNombreCompleto());

        // Le sumo 0 en lugar de -5 para probar el comportamiento base de los puntos
        participante.ganarPuntos(0);
        assertEquals(0, participante.getPuntos());
    }
}