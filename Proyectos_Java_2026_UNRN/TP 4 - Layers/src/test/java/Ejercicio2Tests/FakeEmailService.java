package Ejercicio2Tests;

import ar.unrn.tp4.ejercicio2.modelo.MailProvider;

public class FakeEmailService implements MailProvider {
    public static int CONTADOR_MAILSENVIADOS = 0;

    @Override
    public void enviarMail(String destinatario, String asunto, String mensaje) {
        // Simula el envío de un correo electrónico
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
        CONTADOR_MAILSENVIADOS++;
    }
}
