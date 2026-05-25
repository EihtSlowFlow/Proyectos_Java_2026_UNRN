package ar.unrn.tp5.ejercicio5;

public class PorCorreoEnMemoria implements Inscribible{
    private Inscribible inscribe;
    public PorCorreoEnMemoria(Inscribible inscribe) {
        this.inscribe = inscribe;
    }

    @Override
    public void inscribir(Participante participante) {
        System.out.println("Enviando notificación por correo a " + participante.getCorreoElectronico());
        inscribe.inscribir(participante);
    }
}
