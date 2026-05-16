package ar.unrn.tp4_1.ejercicio2;

import java.util.List;

public class HistoriaUsuario implements ItemDeProyecto {
    private String usuario;
    private String descripcion;
    private List<ItemDeProyecto> tareas;

    public HistoriaUsuario(String usuario, String descripcion, List<ItemDeProyecto> tareas) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.tareas = tareas;
    }

    @Override
    public int calcularTiempo() {
        int tiempoTotal = 0;
        for (ItemDeProyecto tarea : tareas) {
            tiempoTotal+= tarea.calcularTiempo();
        }
        return tiempoTotal;
    }
}
