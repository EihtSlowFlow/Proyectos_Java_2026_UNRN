package ar.unrn.observer.ejercicio4.dominio;

public class ObservadorEmail implements Observer {
    @Override
    public void actualizarInscripcion() {
        System.out.println("Se ha registrado un nuevo participante, se enviará un email de confirmación.");
        //*Podría haber utilizado mailtrap*//
    }
}
