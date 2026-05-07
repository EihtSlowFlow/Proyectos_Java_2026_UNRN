package ar.unrn.tp5.ejercicio2;

public class Tarea {
    private String descripcion;
    private int tiempoEstimado; // Horas
    Tarea(String descripcion, int tiempoEstimado) {
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
    }
    public int tiempoEstimado() {
        return tiempoEstimado;
    }
}
