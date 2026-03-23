package ar.edu.unrn.modelo.Punto1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestExportReal {
    private FileExportConcurso exportReal;
    private FileExportConcurso exportTrucho;
    private Participante LocDog;
    private Participante Cenicero;
    private Participante HorseWithNoName;
    private Concurso comerSanbuchitoMiga;
    private Concurso deletreoEnIngles;
    private Concurso concursoFalso710;


    /// Fecha
    LocalDate FECHA_CONCURSO_MIGA = LocalDate.of(2024, 6, 1);
    LocalDate FECHA_CONCURSO_DELETREO = LocalDate.of(2024, 6, 2);
    LocalDate FECHA_CONCURSO_FALSO = LocalDate.of(2099, 2, 1);


    @BeforeEach
    void setup() throws IOException {
        // Configuramos el exportador real con una ruta de archivo temporal
        String rutaArchivo = "/home/ramiro/tp2-punto1-participantesExportados.txt";
        new FileWriter(rutaArchivo, false).close(); // Limpiamos el archivo antes de cada test
        exportReal = new FileExportConcurso(rutaArchivo);
        /// Para simular el error de exportación, intentamos usar una ruta no válida (en sistemas Unix, esta ruta no existe)
        String rutaFalsa = "/N/O/E/X/I/S/T/E";
        exportTrucho = new FileExportConcurso(rutaFalsa);

        // Creamos un concurso con el exportador real
        comerSanbuchitoMiga = new Concurso(FECHA_CONCURSO_MIGA, FECHA_CONCURSO_MIGA.plusDays(5),
                "Concurso de Comer Sanbuchito de Miga", exportReal);
        deletreoEnIngles = new Concurso(FECHA_CONCURSO_DELETREO, FECHA_CONCURSO_DELETREO.plusDays(5),
                "Concurso de Deletreo en Inglés", exportReal);

        concursoFalso710 = new Concurso(FECHA_CONCURSO_FALSO, FECHA_CONCURSO_FALSO.plusDays(5),
                "Concurso Falso 710", exportTrucho);

        // Seteamos la fecha actual para permitir la inscripción
        comerSanbuchitoMiga.setFechaActual(FECHA_CONCURSO_MIGA);
        deletreoEnIngles.setFechaActual(FECHA_CONCURSO_DELETREO);
        concursoFalso710.setFechaActual(FECHA_CONCURSO_FALSO);

        // Creamos participantes
        LocDog = new Participante("Loc", "Dog", 30, 87654321);
        Cenicero = new Participante("Cenicero", "Zero", 25, 11223344);
        HorseWithNoName = new Participante("Horse", "WithNoName", 40, 99887766);


    }

    @Test
    public void exportarArchivoReal() {

        Path rutaArchivo = Path.of("/home/ramiro/tp2-punto1-participantesExportados.txt");
        comerSanbuchitoMiga.inscribirParticipante(LocDog);
        deletreoEnIngles.inscribirParticipante(Cenicero);

        ///comerSanbuchitoMiga.export(); ya lo llama dentro del concurso cuando se inscribe alguien

        String salidaEsperada = "01/06/2024, 87654321, Concurso de Comer Sanbuchito de Miga";
        String salidaEsperada2 = "02/06/2024, 11223344, Concurso de Deletreo en Inglés";

        try {
            String contenidoArchivo = Files.readString(rutaArchivo);

            Assertions.assertTrue(contenidoArchivo.contains(salidaEsperada),
                    "El archivo no contiene la línea esperada para el concurso de comer sanbuchito de miga.");

            Assertions.assertTrue(contenidoArchivo.contains(salidaEsperada2),
                    "El archivo no contiene la línea esperada para el concurso de deletreo en inglés.");

        } catch (Exception e) {
            Assertions.fail("No se pudo leer el archivo exportado: " + e.getMessage());
        }

    }

    @Test
    void FileExportConcursoLanzaExcepcion() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            concursoFalso710.inscribirParticipante(HorseWithNoName);
        });
        Assertions.assertTrue(exception.getMessage().contains("Error al exportar los datos"),
                "La excepción debería contener el mensaje de error de exportación.");
    }
}