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
    static public void main(String[] args) {
        ProyectoScrum proyectoScrum = new ProyectoScrum();
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Diseñar la interfaz de usuario", 5));
        tareas.add(new Tarea("Implementar la lógica de negocio", 10));
        HistoriaUsuario historiaUsuario = new HistoriaUsuario("AdministradorGeneralSuperior", "como usuario quiero hacer algo porque si", tareas);
        Spike spike = new Spike("Investigar tecnologías de frontend", 3);
        proyectoScrum.itemsDeProyecto = new ArrayList<>();
        proyectoScrum.itemsDeProyecto.add(historiaUsuario);
        proyectoScrum.itemsDeProyecto.add(spike);
        System.out.println("Tiempo estimado(horas): " + proyectoScrum.calcularTiempoTotal());
    }

}
