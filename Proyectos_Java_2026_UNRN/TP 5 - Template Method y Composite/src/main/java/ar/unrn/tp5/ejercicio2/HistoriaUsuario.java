package ar.unrn.tp5.ejercicio2;

import java.util.List;

public class HistoriaUsuario implements ItemDeProyecto {
    private String usuario;
    private String descripcion;
    private List<Tarea> tareas;

    public HistoriaUsuario(String usuario, String descripcion, List<Tarea> tareas) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.tareas = tareas;
    }

    @Override
    public int calcularTiempo() {
        int tiempoTotal = 0;
        for (Tarea tarea : tareas) {
            tiempoTotal+= tarea.tiempoEstimado();
        }
        return tiempoTotal;
    }
}
