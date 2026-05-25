package ar.unrn.tp5.ejercicio5;

public class PorWhatsapp implements Inscribible {
    Inscribible inscribe;
    public PorWhatsapp(Inscribible inscribe) {
        this.inscribe = inscribe;
    }

    @Override
    public void inscribir(Participante participante) {
        System.out.println("Enviando notificación por Whatsapp a " + participante.getNombreCompleto());
        this.inscribe.inscribir(participante);
    }
}
