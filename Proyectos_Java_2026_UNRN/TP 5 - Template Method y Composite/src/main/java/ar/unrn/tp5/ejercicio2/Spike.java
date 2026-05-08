package ar.unrn.tp5.ejercicio2;

public class Spike implements ItemDeProyecto {
    private String descripcion;
    private  int tiempoEstimado; // en horas

    public Spike(String descripcion, int tiempoEstimado) {
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public int calcularTiempo() {
        return tiempoEstimado;
    }
}
