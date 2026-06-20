package argel.framework;

/**
 * Crea instancias de {@link Accion} a partir de su nombre de clase completo.
 * <p>
 * Esta clase usa Reflection para localizar la clase en el classpath, instanciarla
 * y realizar el casteo al tipo {@link Accion}. Si ocurre cualquier error se lanza
 * {@link ActionException} con información de la causa.
 */
public class Accionador {

    LectorConfiguracion lectorConfiguracion;

    public Accionador(){
    }

    /**
     * Crea una acción a partir del nombre completo de la clase.
     * @param nombreClase nombre completo (incluye paquete) de la clase que implementa Accion
     * @return instancia de Accion
     * @throws ActionException si la clase no existe, no implementa Accion o no puede instanciarse
     */
    public Accion crearAccion(String nombreClase){
        try{
            // Reflection
            Class<?> clase = Class.forName(nombreClase);
            Object accionDesconocida = clase.getDeclaredConstructor().newInstance();
            Accion accion = (Accion) accionDesconocida;
            return accion; // O devuelve la acción o arroja excepcion
        } catch (ClassNotFoundException e) {
            throw new ActionException("La clase '" + nombreClase + "' no existe en el proyecto.", e);
        } catch (ClassCastException e) {
            throw new ActionException("La clase '" + nombreClase + "' debe implementar la interfaz Accion.", e);
        } catch (ReflectiveOperationException e) {
            throw new ActionException("No se pudo instanciar la clase '" + nombreClase + "'.", e);
        }
    }


}
