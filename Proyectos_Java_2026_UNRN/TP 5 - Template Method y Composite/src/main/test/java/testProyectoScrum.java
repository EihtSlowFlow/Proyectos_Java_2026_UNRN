import java.util.List;

import ar.unrn.tp5.ejercicio2.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testProyectoScrum {
    @Test
    public void testProyectoScrumTotal() {
        List<ItemDeProyecto> items = List.of(
                new HistoriaUsuario("Usuario1", "Descripcion1", List.of(new Tarea("Tarea1", 3), new Tarea("Tarea2", 2))),
                new HistoriaUsuario("Usuario2", "Descripcion2", List.of(new Tarea("Tarea3", 4), new Tarea("Tarea4", 1))),
                new Spike("Spike1", 5)
        );
        ProyectoScrum proyectoScrum = new ProyectoScrum(items);
        int tiempoTotal = proyectoScrum.mostrar();
        assertEquals(15, tiempoTotal);
    }
    @Test
    public void testProyectoScrumParcial() {
        List<ItemDeProyecto> items = List.of(
                new Spike("Spike1", 15),new Spike("Spike2", 5)
                );
        ProyectoScrum proyectoScrum = new ProyectoScrum(items);
        int tiempoParcial = proyectoScrum.mostrar();
        assertEquals(20, tiempoParcial);
    }


}
