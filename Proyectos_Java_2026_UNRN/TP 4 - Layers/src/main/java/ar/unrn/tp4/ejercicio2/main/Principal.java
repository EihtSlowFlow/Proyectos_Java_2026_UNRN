package ar.unrn.tp4.ejercicio2.main;

import ar.unrn.tp4.ejercicio2.modelo.ExportProvider;
import ar.unrn.tp4.ejercicio2.modelo.MailProvider;
import ar.unrn.tp4.ejercicio2.modelo.SistemaNotificador;
import ar.unrn.tp4.ejercicio2.persistencia.EmailService;
import ar.unrn.tp4.ejercicio2.persistencia.FileManager;

// La entrada de datos se hace desde el archivo con el formato estipulado.
public class Principal {
    public static void main(String[] args) {


        ExportProvider exportProvider = new FileManager("/home/ramiro/archivo_empleados_TP4-Layers.txt");
        MailProvider mailProvider = new EmailService();
        // Recordatorio --> LocalDate formatea sus fechas separandolas con '-', si yo le mando un '/' no va a entender nada
        // agarra, define un formato, y cuando el CompetitionManagement agarre ese texto pueda parsearlo a un formato que LocalDate entienda, es decir,
        // el definido en el DateTimeFormatter.ofPattern("yyyy/M/d") que separa por / en lugar de -
        SistemaNotificador sistemaNotificador = new SistemaNotificador(exportProvider, mailProvider);
        sistemaNotificador.enviarNotificacionCumpleanos();


    }
}
