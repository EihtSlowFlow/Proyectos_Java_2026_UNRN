package argel.framework;

/**
 * Interfaz que deben implementar las acciones manejadas por el framework.
 * <p>
 * Cada implementación representa una entrada del menú y debe proporcionar
 * su ejecución y textos para mostrarse en el menú.
 */
public interface Accion {

    /** Ejecuta la acción seleccionada por el usuario. */
    void ejecutar();

    /** Texto que se mostrará como nombre del ítem en el menú. */
    String nombreItemMenu();

    /** Texto que se mostrará como descripción del ítem en el menú. */
    String descripcionItemMenu();
}
