package ar.edu.unrn.infraestructura;

public interface Notificador {
    void enviarNotificacion(String destino, String asunto, String mensaje);
}
