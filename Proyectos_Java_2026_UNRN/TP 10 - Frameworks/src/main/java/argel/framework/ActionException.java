package argel.framework;

/**
 * Excepción genérica del framework para reportar errores en tiempo de ejecución.
 * Extiende {@link RuntimeException} para no forzar su declaración en el API público.
 */
public class ActionException extends RuntimeException {
    public ActionException(String message) {
        super(message);
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
