package ar.edu.unrn.modelo.Punto1;

import ar.edu.unrn.infraestructura.Notificador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestConcursoExportInMemory {
    private EnMemoriaExport exportUnificado;
    private EnMemoriaExport exportSimplificado;
    private Notificador noti;
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
        noti = new MockEmailService();
        exportUnificado = new EnMemoriaExport();
        exportSimplificado = new EnMemoriaExport();

        // Instanciamos los concursos inyectando la función Lambda (Supplier) con la fecha estática
        concursoEmpanadas = new Concurso(FECHA_EMPANADAS.minusDays(1), FECHA_EMPANADAS.plusDays(5),
                "Concurso de Comer Empanadas", exportUnificado, noti, () -> FECHA_EMPANADAS);

        concursoBaile = new Concurso(FECHA_BAILE.minusDays(1), FECHA_BAILE.plusDays(5),
                "Concurso de Baile", exportUnificado, noti, () -> FECHA_BAILE);

        concursoLetras = new Concurso(FECHA_LETRAS.atStartOfDay().toLocalDate(), FECHA_LETRAS.plusDays(5),
                "Concurso de Letras", exportSimplificado, noti, () -> FECHA_LETRAS);
    }

    @Test
    public void testExportarAlInscribir() {
        Participante barney = new Participante("Barney", "Gomez", 40, 12345678, "barney@gmail.com");

        // Al inscribir, ya debería dispararse la exportación según la consigna
        concursoLetras.inscribirParticipante(barney);

        String datosExportados = exportSimplificado.datos();

        // Formato esperado según la consigna: dd/mm/yyyy, id_participante, id_concurso

        String lineaEsperada = "01/04/2026, 12345678, Concurso de Letras";

        Assertions.assertTrue(datosExportados.contains(lineaEsperada),
                "El archivo no contiene el formato exacto pedido por el profesor.");
    }

    @Test
    public void testInscripcionesVariosConcursosEnMismoArchivo() {

        Participante barney = new Participante("Barney", "Gomez", 40, 12345678, "JoaoDoJorel@yahoo.com");
        Participante betty = new Participante("Betty", "Smith", 30, 87654321, "123BettySmith123@gmail.com");

        concursoEmpanadas.inscribirParticipante(barney);
        concursoBaile.inscribirParticipante(betty);

        concursoBaile.export();
        concursoEmpanadas.export();

        String todosLosDatos = exportUnificado.datos();

        String lineaBarney = "26/03/2026, 12345678, Concurso de Comer Empanadas";
        String lineaBetty = "24/03/2026, 87654321, Concurso de Baile";

        Assertions.assertTrue(todosLosDatos.contains(lineaBarney),
                "No se encontró la línea de Barney o el formato es incorrecto.");
        Assertions.assertTrue(todosLosDatos.contains(lineaBetty),
                "No se encontró la línea de Betty o el formato es incorrecto.");
    }
}