package ar.unrn.tp4.ejercicio1.dominio;

public class CrearParticipante {

    private final ParticipanteRepository repo;

    public CrearParticipante(ParticipanteRepository repo) {
        this.repo = repo;
    }

    public void ejecutar(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);
        repo.guardar(participante);
    }
}