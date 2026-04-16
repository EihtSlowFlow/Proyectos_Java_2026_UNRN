package Ejercicio2Tests;

public class FakeEmailService {
    public static int CONTADOR_MAILSENVIADOS = 0;
    private String destinatario;
    private String asunto;
    private String mensaje;

    public void enviarMail(String destinatario, String asunto, String mensaje) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
        CONTADOR_MAILSENVIADOS++;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }
}
