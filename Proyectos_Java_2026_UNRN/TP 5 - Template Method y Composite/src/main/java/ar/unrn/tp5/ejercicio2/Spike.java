package ar.unrn.tp5.ejercicio2;

public class Spike implements ItemDeProyecto {
    // También tenemos ítems de tipo spike (tareas de análisis)
    String descripcion;
    int tiempoEstimado; // en horas

    public Spike(String descripcion, int tiempoEstimado) {
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public int calcularTiempo() {
        return  tiempoEstimado;
    }
}
