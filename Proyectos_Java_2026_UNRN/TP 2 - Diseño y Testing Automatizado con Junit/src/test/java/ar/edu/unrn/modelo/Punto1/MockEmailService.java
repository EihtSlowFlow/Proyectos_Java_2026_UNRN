package ar.edu.unrn.modelo.Punto1;

import ar.edu.unrn.infraestructura.Notificador;

public class MockEmailService implements Notificador {
    private int contadorEmail = 0;
    private String ultimoDestino;

    @Override
    public void enviarNotificacion(String destino, String asunto, String mensaje) {
        this.contadorEmail++;
        this.ultimoDestino = destino;
        System.out.println("Envio falso a: " + destino);
    }

    public int getContadorEmail() {
        return contadorEmail;
    }
}
