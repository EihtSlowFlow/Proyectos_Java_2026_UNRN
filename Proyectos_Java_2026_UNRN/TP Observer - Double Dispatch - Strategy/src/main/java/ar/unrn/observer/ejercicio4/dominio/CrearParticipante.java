package ar.unrn.observer.ejercicio4.dominio;

import java.util.ArrayList;
import java.util.List;

public class CrearParticipante {
    private final ParticipanteRepository repo;
    private final List<Observer> observadores;
    public CrearParticipante(ParticipanteRepository repo) {
        this.repo = repo;
        observadores = new ArrayList<>();
    }
    public void ejecutar(String nombre, String telefono, String region, String text) {
        Participante participante = new Participante(nombre, telefono, region);
        notifyObservers();
        repo.guardar(participante);
    }
    public void  addObserver(Observer obs) {
        observadores.add(obs);
    }
    public void  removeObserver(Observer obs) {
        observadores.remove(obs);
    }
    public void notifyObservers() {
        for (Observer obs : observadores) {
            obs.actualizarInscripcion();
        }
    }

}