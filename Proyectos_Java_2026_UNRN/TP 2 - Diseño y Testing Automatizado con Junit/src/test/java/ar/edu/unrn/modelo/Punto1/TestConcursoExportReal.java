package ar.edu.unrn.modelo.Punto1;

import ar.edu.unrn.infraestructura.Notificador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestConcursoExportReal {
    private Participante locDog;
    private Participante cenicero;
    private Participante horseWithNoName;
    private Notificador noti;
    private Concurso comerSanbuchitoMiga;
    private Concurso deletreoEnIngles;
    private Concurso concursoFalso710;

    /// Ruta estática exigida
    private final String RUTA_ARCHIVO = "/home/ramiro/tp2-punto1-participantesExportados.txt";

    /// Fechas
    private final LocalDate FECHA_CONCURSO_MIGA = LocalDate.of(2024, 6, 1);
    private final LocalDate FECHA_CONCURSO_DELETREO = LocalDate.of(2024, 6, 2);
    private final LocalDate FECHA_CONCURSO_FALSO = LocalDate.of(2099, 2, 1);

    @BeforeEach
    void setup() throws IOException {
        noti = new MockEmailService();

        // Limpiamos el archivo o lo creamos vacío antes de cada test para que no se acumule basura
        Files.writeString(Path.of(RUTA_ARCHIVO), "");

        FileExportConcurso exportReal = new FileExportConcurso(RUTA_ARCHIVO);

        // Ruta falsa para el test de excepción
        String rutaFalsa = "/N/O/E/X/I/S/T/E/archivo.txt";
        FileExportConcurso exportTrucho = new FileExportConcurso(rutaFalsa);

        comerSanbuchitoMiga = new Concurso(FECHA_CONCURSO_MIGA, FECHA_CONCURSO_MIGA.plusDays(5),
                "Concurso de Comer Sanbuchito de Miga", exportReal, noti, () -> FECHA_CONCURSO_MIGA);

        deletreoEnIngles = new Concurso(FECHA_CONCURSO_DELETREO, FECHA_CONCURSO_DELETREO.plusDays(5),
                "Concurso de Deletreo en Inglés", exportReal, noti, () -> FECHA_CONCURSO_DELETREO);

        concursoFalso710 = new Concurso(FECHA_CONCURSO_FALSO, FECHA_CONCURSO_FALSO.plusDays(5),
                "Concurso Falso 710", exportTrucho, noti, () -> FECHA_CONCURSO_FALSO);

        locDog = new Participante("Loc", "Dog", 30, 87654321, "locdog@gmail.com");
        cenicero = new Participante("Cenicero", "Zero", 25, 11223344, "cenicero@gmail.com");
        horseWithNoName = new Participante("Horse", "WithNoName", 40, 99887766, "horse@gmail.com");
    }

    @Test
    public void exportarArchivoReal() throws IOException {

        comerSanbuchitoMiga.inscribirParticipante(locDog);
        deletreoEnIngles.inscribirParticipante(cenicero);

        comerSanbuchitoMiga.export();
        deletreoEnIngles.export();


        Path rutaArchivo = Path.of(RUTA_ARCHIVO);
        String contenidoArchivo = Files.readString(rutaArchivo);


        String salidaEsperadaMiga = "01/06/2024, 87654321, Concurso de Comer Sanbuchito de Miga, locdog@gmail.com";
        String salidaEsperadaDeletreo = "02/06/2024, 11223344, Concurso de Deletreo en Inglés, cenicero@gmail.com";

        Assertions.assertTrue(contenidoArchivo.contains(salidaEsperadaMiga),
                "El archivo no contiene la línea esperada para el concurso de comer sanbuchito de miga.");

        Assertions.assertTrue(contenidoArchivo.contains(salidaEsperadaDeletreo),
                "El archivo no contiene la línea esperada para el concurso de deletreo en inglés.");
    }

    @Test
    void FileExportConcursoLanzaExcepcion() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            // Inscribimos al participante
            concursoFalso710.inscribirParticipante(horseWithNoName);

            // FORZAMOS LA EXPORTACIÓN para que intente escribir en la ruta falsa "/N/O/E/X/I/S/T/E/" y explote
            concursoFalso710.export();
        });

        Assertions.assertTrue(exception.getMessage().contains("Error al exportar los datos") || exception.getMessage().contains("export"),
                "La excepción debería contener el mensaje de error de exportación.");
    }
}