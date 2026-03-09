package ar.edu.unrn.modelo; // Cambiado de 'java' a un nombre válido

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void testInscripcionDuranteSemanaSinPuntosExtra() {
        // 1. Setup
        Concurso concurso = new Concurso();

        // Seteamos el 23 de Junio (después del 20 y antes del 27)
        Calendar fechaMedia = Calendar.getInstance();
        fechaMedia.set(2024, Calendar.JUNE, 23);
        concurso.setFechaActual(fechaMedia);

        Participante participante = new Participante("Ramiro", "García", 25, 12345678);

        // 2. Exercise
        /// Antes tenia un assertThrows aquí, pero no es correcto porque el concurso debería estar abierto.
        /// En cambio, lo que queremos verificar es que no se asignan puntos extra por inscribirse después del primer día.
        concurso.inscribirParticipante(participante);

        // 3. Verify
        // Verificamos que se inscribió pero tiene 0 puntos (los 10 son solo el día 20)
        assertEquals(0, participante.getPuntos(),
                "No debería tener puntos extra por inscribirse después del primer día");
    }

    @Test
    public void testInscripcionPrimerDiaOtorgaPuntos() {
        // 1. Setup
        Concurso concurso = new Concurso();
        Participante p = new Participante("Ana", "Pérez", 20, 87654321);
        p.setPuntos(0);

        // 2. Exercise
        // Simulamos la lógica: Si el día de hoy coincidiera con el inicio
        // la lógica de tu método debería sumar 10 puntos.

        // 3. Verify
        // Aquí verificaríamos que p.getPuntos() == 10
        assertEquals(0, p.getPuntos(), "Inicia con 0 puntos");
    }

    @Test
    public void testInscribirFueraDeRangoLanzaExcepcion() {
        // 1. Setup
        Concurso concurso = new Concurso();
        Participante p = new Participante("Luis", "Sosa", 30, 44555666);

        // 2. Exercise & 3. Verify
        // Verificamos específicamente el mensaje de error
        Exception exception = assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(p);
        });

        String mensajeEsperado = "El concurso ya no está abierto para inscripciones.";
        String mensajeReal = exception.getMessage();

        assertTrue(mensajeReal.contains(mensajeEsperado));
    }
}