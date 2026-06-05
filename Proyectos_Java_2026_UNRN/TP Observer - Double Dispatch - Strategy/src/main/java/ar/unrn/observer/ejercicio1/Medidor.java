package ar.unrn.observer.ejercicio1;

import java.util.List;

public class Medidor {

    private final ClimaOnline clima;
    protected List<Observer> observadores;

    public Medidor(ClimaOnline clima, List<Observer> observers) {
        this.clima = clima;
        this.observadores = observers;
    }

    public String leerTemperatura() {
        // Leo la temperatura del servicio web
        String temperatura = this.clima.temperatura();
        avisarObservadores(temperatura);
        return temperatura;
    }


    void avisarObservadores(String temperatura) {
        for (Observer observer : observadores) {
            observer.actualizarTemperatura(temperatura);
        }
    }
}