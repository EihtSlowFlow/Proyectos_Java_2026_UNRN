package ar.unrn.tp4_1.ejercicio2;

import java.util.List;

public class ProyectoScrum{

    List<ItemDeProyecto> itemsDeProyecto;
    public ProyectoScrum(List<ItemDeProyecto> itemsDeProyecto) {
        this.itemsDeProyecto = itemsDeProyecto;
    }
        public int mostrar () {
            int tiempoTotal = 0;
            for (ItemDeProyecto item : itemsDeProyecto) {
                tiempoTotal += item.calcularTiempo();
            }
            return tiempoTotal;
        }
    }
