package argel.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Fachada del framework: arma las piezas (lector de configuración, creador de acciones
 * y menú) y lanza la ejecución.
 */
public class Start {
    private String configPath;

    /** El constructor recibe el configPath que el usuario desee utilizar. */
    public Start(String configPath) {
        this.configPath = configPath;
    }

    /**
     * Inicializa el framework leyendo la configuración, creando las acciones y mostrando
     * el menú interactivo.
     */
    public void init() {
        try {
            // Lee el path configurado y trae las clases
            LectorConfiguracion lector = new LectorConfiguracion();
            List<String> nombresClases = lector.obtenerNombresClases(this.configPath);

            // Crea instancias de accion
            Accionador acciones = new Accionador();
            List<Accion> accionesListas = new ArrayList<>();
            for (String nombre : nombresClases) {
                // Acá adentro va creando las acciones, si ocurre un error lo soluciona dentro de la implementacion de crearAccion.
                accionesListas.add(acciones.crearAccion(nombre));
            }

            // Menu
            MenuFramework menu = new MenuFramework(accionesListas);
            menu.mostrarYEjecutar();

        } catch (Exception e) {
            System.err.println("Error fatal iniciando el Framework: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
