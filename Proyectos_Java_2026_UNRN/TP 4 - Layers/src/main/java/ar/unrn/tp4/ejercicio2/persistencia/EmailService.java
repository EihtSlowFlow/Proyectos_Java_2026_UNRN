package ar.unrn.tp4.ejercicio2.persistencia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ar.unrn.tp4.ejercicio2.modelo.MailProvider;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailService implements MailProvider {
    private final Properties prop = new Properties();

    public EmailService() {
        // Carga el archivo una sola vez cuando se crea el servicio
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("No se encontró config.properties en resources");
            }
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer config.properties", e);
        }
    }

    public void enviarNotificacion(String destino, String asunto, String mensaje) {
        Session session = Session.getInstance(this.prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String user = prop.getProperty("mail.smtp.user");
                String pass = prop.getProperty("mail.smtp.password");

                System.out.println("DEBUG - Usuario leído: [" + user + "]");

                if (user == null || pass == null) {
                    throw new RuntimeException("Credenciales no encontradas en el archivo.");
                }
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("unrn@ejemplo.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            System.out.println("¡Correo capturado por Mailtrap!");
        } catch (MessagingException e) {
            throw new RuntimeException("Error en el envío SMTP", e);
        }
    }

    @Override
    public void enviarMail(String destinatario, String asunto, String mensaje) {
        enviarNotificacion(destinatario, asunto, mensaje);
    }
}