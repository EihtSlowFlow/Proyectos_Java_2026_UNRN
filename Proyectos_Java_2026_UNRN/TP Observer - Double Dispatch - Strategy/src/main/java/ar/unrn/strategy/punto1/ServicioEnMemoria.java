package ar.unrn.strategy.punto1;

public class ServicioEnMemoria implements ServicioWeb {
    @Override
    public double determinarKilometraje() {
        return  (Math.random() * 2561) + 500; // Simula la obtención del kilometraje desde una conexión web;
    }
}
