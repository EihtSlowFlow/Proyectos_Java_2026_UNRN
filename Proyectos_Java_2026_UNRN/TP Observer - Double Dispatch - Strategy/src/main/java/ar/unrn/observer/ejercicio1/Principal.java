package ar.unrn.observer.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Observer> observadores = new ArrayList<>();
        Observer logger = new ObservadorLog();
        observadores.add(logger);
        observadores.add(new ObservadorTemperatura());

        ClimaOnline servicioClima = new WeatherChannelService();

        Medidor medidor = new Medidor(servicioClima,observadores);

        String resultado = medidor.leerTemperatura();
        System.out.println(resultado);
    }
}
