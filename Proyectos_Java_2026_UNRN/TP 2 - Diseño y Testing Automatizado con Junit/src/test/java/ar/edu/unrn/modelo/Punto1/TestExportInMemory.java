package ar.edu.unrn.modelo.Punto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestExportInMemory {
    private EnMemoriaExport exportUnificado;
    private EnMemoriaExport exportSimplificado;
    private Concurso concursoEmpanadas;
    private Concurso concursoBaile;
    private Concurso concursoLetras;

    // Fechas de prueba
    private final LocalDate FECHA_EMPANADAS = LocalDate.of(2026, 3, 26);
    private final LocalDate FECHA_BAILE = LocalDate.of(2026, 3, 24);
    private final LocalDate FECHA_LETRAS = LocalDate.of(2026, 4, 1);


    @BeforeEach
    void setUp() {

        // Los "Test Double"
        exportUnificado = new EnMemoriaExport();
        exportSimplificado = new EnMemoriaExport();

        // Instanciamos los concursos con los exportadores
        // Usamos fechas de inicio/fin coherentes para que permitan la inscripción
        concursoEmpanadas = new Concurso(FECHA_EMPANADAS.minusDays(1), FECHA_EMPANADAS.plusDays(5),
                "Concurso de Comer Empanadas", exportUnificado);

        concursoBaile = new Concurso(FECHA_BAILE.minusDays(1), FECHA_BAILE.plusDays(5),
                "Concurso de Baile", exportUnificado);

        concursoLetras = new Concurso(FECHA_LETRAS.atStartOfDay().toLocalDate(), FECHA_LETRAS.plusDays(5), "Concurso de Letras", exportSimplificado);

        // Seteamos la "fecha de hoy" para cada concurso
        concursoEmpanadas.setFechaActual(FECHA_EMPANADAS);
        concursoBaile.setFechaActual(FECHA_BAILE);
        concursoLetras.setFechaActual(FECHA_LETRAS);
    }

    @Test
    public void testExportarAlInscribir() {
        Participante barney = new Participante("Barney", "Gomez", 40, 12345678);

        // Al inscribir, ya debería dispararse la exportación según la consigna
        concursoLetras.setFechaActual(FECHA_LETRAS); // Aseguramos que la fecha actual es la de inicio
        concursoLetras.inscribirParticipante(barney);

        String datosExportados = exportSimplificado.datos();

        // Formato esperado según la consigna: dd/mm/yyyy, id_participante, id_concurso
        String lineaEsperada = String.format("1/04/2026, 12345678, %s", "Concurso de Letras");

        Assertions.assertTrue(datosExportados.contains(lineaEsperada),
                "El archivo no contiene el formato exacto pedido por el profesor.");
    }

    @Test
    public void testInscripcionesVariosConcursosEnMismoArchivo() {
        Participante barney = new Participante("Barney", "Gomez", 40, 12345678);
        Participante betty = new Participante("Betty", "Smith", 30, 87654321);

        concursoEmpanadas.inscribirParticipante(barney);
        concursoBaile.inscribirParticipante(betty);

        String todosLosDatos = exportUnificado.datos();

        String lineaBarney = "26/03/2026, 12345678, Concurso de Comer Empanadas";
        String lineaBetty = "24/03/2026, 87654321, Concurso de Baile";

        Assertions.assertTrue(todosLosDatos.contains(lineaBarney),
                "No se encontró la línea de Barney o el formato es incorrecto.");
        Assertions.assertTrue(todosLosDatos.contains(lineaBetty),
                "No se encontró la línea de Betty o el formato es incorrecto.");
    }
}