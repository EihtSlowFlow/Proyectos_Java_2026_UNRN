package ar.unrn.tp5.ejercicio2;
/*
Un Proyecto en Scrum está compuesto de muchos ítems de trabajo. Un ítem del
proyecto puede ser una historia de usuario, y las historias se componen de tareas.
También tenemos ítems de tipo spike (tareas de análisis).

a) Aplicando el patrón Composite diseñe el diagrama de clases que permita modelar este
escenario y que permita calcular el tiempo necesario para completar un proyecto o
alguna parte del mismo.

b) Implemente la solución en Java y escriba dos casos de test.
 */

import java.util.ArrayList;
import java.util.List;
public class Principal {
    public static void main(String[] args) {
        List<ItemDeProyecto> items = new ArrayList<>();
        items.add(new HistoriaUsuario("Usuario1", "Descripcion1", List.of(new Tarea("Tarea1", 3)
                , new Tarea("Tarea2", 2))));
        items.add(new HistoriaUsuario("Usuario2", "Descripcion2", List.of(new Tarea("Tarea3", 4),
                new Tarea("Tarea4", 1))));
        items.add(new Spike("Spike1", 5));
        ProyectoScrum proyectoScrum = new ProyectoScrum(items);
        System.out.println("Tiempo estimado en horas de proyecto: " + proyectoScrum.mostrar());

    }

}
