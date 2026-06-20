package argel.framework; // Asegurate de que el paquete sea este

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AccionesLoaderTESTs {

    private LectorConfiguracion lector;
    private Accionador motor;

    @BeforeEach
    void setUp() {
        lector = new LectorConfiguracion();
        motor = new Accionador();
    }

    @Test
    @DisplayName("Debe cargar correctamente una lista de acciones desde el archivo config.properties")
    void testCargaExitosaDeArchivo() {
        String ruta = "/config.properties";

        List<String> clases = lector.obtenerNombresClases(ruta);

        assertNotNull(clases);
        assertEquals(2, clases.size(), "Debería haber detectado exactamente 2 clases");
        assertEquals("argel.utilizacion.AccionUno", clases.get(0));
    }

    @Test
    @DisplayName("Debe lanzar ActionException si el archivo no existe en el disco")
    void testArchivoInexistente() {
        String rutaInexistente = "/ruta-falsa.properties";
        assertThrows(ActionException.class, () -> {
            lector.obtenerNombresClases(rutaInexistente);
        });
    }

    @Test
    @DisplayName("Debe instanciar correctamente una clase real del proyecto")
    void testInstanciacionExitosa() {
        String claseValida = "argel.utilizacion.AccionUno";

        Accion instancia = motor.crearAccion(claseValida);

        assertNotNull(instancia);
        assertTrue(instancia instanceof Accion);
    }

    @Test
    @DisplayName("Debe lanzar ActionException si el nombre de la clase no existe")
    void testClaseNoEncontrada() {
        String claseInventada = "argel.utilizacion.ClaseFalsa";

        assertThrows(ActionException.class, () -> {
            motor.crearAccion(claseInventada);
        });
    }
}