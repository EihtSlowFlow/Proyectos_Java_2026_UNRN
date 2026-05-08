package ar.unrn.tp5.ejercicio2;

public class Tarea implements ItemDeProyecto {
    private String descripcion;
    private final int tiempoEstimado; // Horas
    public Tarea(String descripcion, int tiempoEstimado) {
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public int calcularTiempo() {
        return tiempoEstimado;
    }
}
