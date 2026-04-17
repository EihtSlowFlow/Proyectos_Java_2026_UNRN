package Ejercicio2Tests;

import ar.unrn.tp4.ejercicio2.modelo.Empleado;
import ar.unrn.tp4.ejercicio2.modelo.ExportProvider;
import ar.unrn.tp4.ejercicio2.modelo.MailProvider;
import ar.unrn.tp4.ejercicio2.modelo.SistemaNotificador;
import ar.unrn.tp4.ejercicio2.persistencia.EmailService;
import ar.unrn.tp4.ejercicio2.persistencia.FileManager;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSistemaFuncional {

    @Test
    public void testLecturaArchivoReal() throws IOException {
        /// Setup
        // Creación de un archivo temporal
        Path archivoTemporal = Files.createTempFile("empleados_reales", ".txt");

        String contenido = "apellido, nombre, nacimiento, email\n" +
                "Viale, Mauro, 1947/8/28, mauro@viale.com\n" +
                "Perez, Juan, 1990/5/15, juan@perez.com";
        // Escritura sobre el archivo temporal
        Files.writeString(archivoTemporal, contenido);


        FileManager lectorReal = new FileManager(archivoTemporal.toString());
        /// Accion
        List<Empleado> resultado = lectorReal.obtenerEmpleados();

        /// Verificacion
        assertEquals("Debería haber leído 2 empleados", 2, resultado.size());
        assertEquals(LocalDate.of(1947, 8, 28), resultado.get(0).fechaNacimiento());

        /// Limpieza del archivo temporal
        Files.deleteIfExists(archivoTemporal);
    }

    @Test
    public void testEnvioEmailReal() throws IOException {
        /// Setup
        // Usamos la fecha de HOY para asegurar que el test siempre encuentre un cumpleañero
        String hoy = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/M/d"));

        Path archivoTemporal = Files.createTempFile("empleados_reales", ".txt");
        String contenido = "apellido, nombre, nacimiento, email\n" +
                "Viale, Mauro, 1947/8/28, mauro@viale.com\n" +
                "Joao, Perez, " + hoy + ", joao@gmail.com";

        Files.writeString(archivoTemporal, contenido);

        ExportProvider lectorReal = new FileManager(archivoTemporal.toString());
        // Usamos el servicio real que conecta a Mailtrap
        MailProvider mailProvider = new EmailService();
        SistemaNotificador sistemaNotificador = new SistemaNotificador(lectorReal, mailProvider);

        /// Acción
        sistemaNotificador.enviarNotificacionCumpleanos();

        /// 3. Verificación
        // Alguien de fuera no puede ver mailtrap porque no deberían tener acceso al servicio desde mi cuenta
        // por lo tanto, considero como verificación el hecho de que no se hayan lanzado excepciones

        /// 4. Limpieza
        Files.deleteIfExists(archivoTemporal);
    }

}