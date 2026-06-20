package argel.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Lee la configuración de acciones desde un archivo de propiedades.
 * <p>
 * El archivo de propiedades debe contener la clave {@code Acciones} cuyo valor
 * sea una lista separada por punto y coma (;) de nombres de clase (fully-qualified)
 * que implementen {@link Accion}.
 */
public class LectorConfiguracion {
    // Class name property debe tener el mismo nombre, en el config y en donde se va a utilizar para encontrarlo.
    private static final String CLASS_NAME_PROPERTY = "Acciones";
    public static final String ARCHIVO_VACIO_ADV = "El archivo de configuracion está vacío";
    public static final String LECTURA_ARCHIVO_ADV = "Error en la lectura del archivo de configuracion";
    public static final String MISSING_CONFIG_ADV = "No se encontro el archivo configuracion";
    List<String> nombreClases;

    protected LectorConfiguracion(){
        nombreClases = new ArrayList<>();
    }

    List<String> obtenerNombresClases(String configPath){
        Properties prop = new Properties();
        // La lectura inicial se coloca dentro del bloque try, así cierra el archivo tras usarlo automaticamente.
        try (InputStream configFile = getClass().getResourceAsStream(configPath)) {
            if(configFile == null){
                throw new ActionException(MISSING_CONFIG_ADV);
            }
            // Lee el archivo de configuraciones del path compilado
            prop.load(configFile);
            // Obtiene un único String que contiene todas las acciones colocadas en acciones = paquete.accion1; paquete.accionX
            String acciones = prop.getProperty(CLASS_NAME_PROPERTY);
            if(acciones != null && !acciones.isEmpty()){
                // Revisa los delimitadores, agarra y los separa a partir de ';'
                String[] accionesArray = acciones.split(";");
                for(String accion : accionesArray){
                    if(!accion.trim().isEmpty()){
                        nombreClases.add(accion.trim());
                    }
                }
            } else {
                throw new ActionException(ARCHIVO_VACIO_ADV);
            }
        } catch (IOException e) {
            throw new ActionException(LECTURA_ARCHIVO_ADV, e);
        }
        return nombreClases;
    }

}