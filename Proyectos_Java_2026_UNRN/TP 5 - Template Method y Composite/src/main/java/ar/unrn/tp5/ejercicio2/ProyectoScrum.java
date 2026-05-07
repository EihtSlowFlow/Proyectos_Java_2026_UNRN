package ar.unrn.tp5.ejercicio2;

import java.util.List;

public class ProyectoScrum {
    List<ItemDeProyecto> itemsDeProyecto;
     public int calcularTiempoTotal() {
        int tiempoTotal = 0;
        for (ItemDeProyecto item : itemsDeProyecto) {
            tiempoTotal += item.calcularTiempo();
        }
        return tiempoTotal;
    }


}
