package ar.unrn.tp4.ejercicio2.persistencia;

import java.util.Properties;

import ar.unrn.tp4.ejercicio2.modelo.MailProvider;
import jakarta.mail.*;
import jakarta.mail.internet.*;


public class EmailService implements MailProvider {
    public void enviarNotificacion(String destino, String asunto, String mensaje) {
        // Configuraciones provistas por Mailtrap
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");

        // sesión con autenticación
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1c6f432458260d", "2c2610f1fb496f");
            }
        });

        try {
            // Construccion del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("unCorreoDefinitivamenteReal@unrn.edu.ar"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(mensaje);

            //  Envio del mensaje
            Transport.send(message);
            System.out.println("Correo capturado por Mailtrap!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enviarMail(String destinatario, String asunto, String mensaje) {
        enviarNotificacion(destinatario, asunto, mensaje);
    }
}