package Ejercicio2Tests;

import ar.unrn.tp4.ejercicio2.modelo.Empleado;
import ar.unrn.tp4.ejercicio2.modelo.ExportProvider;
import ar.unrn.tp4.ejercicio2.modelo.MailProvider;
import ar.unrn.tp4.ejercicio2.modelo.SistemaNotificador;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSistemaConFakes {
    SistemaNotificador sistemaNotificador;
    MailProvider mailProvider;
    ExportProvider exportProvider;
    List<Empleado> empleadosSimulados;


    public void setup() {
        mailProvider = new FakeEmailService();
        sistemaNotificador = new SistemaNotificador(exportProvider, mailProvider);

    }


    @Test
    public void testEnvioEmail() {
        empleadosSimulados = List.of(
                new Empleado("Perez", "Juan", LocalDate.now(), "ElAquello@gmail.com"),
                new Empleado("Gomez", "Maria", LocalDate.now().minusYears(40), "Mario@gmail.com"),
                new Empleado("Jorge", "Menendez", LocalDate.of(1990, 5, 20), "Joao@gmail.com")
        );
        exportProvider = new FakeFileManager(empleadosSimulados);

        setup();
        sistemaNotificador.enviarNotificacionCumpleanos();
        assertEquals(2, FakeEmailService.CONTADOR_MAILSENVIADOS);

    }

}
