package ar.unrn.tp4.ejercicio2.modelo;

public interface MailProvider {
    void enviarMail(String destinatario, String asunto, String mensaje);
}
