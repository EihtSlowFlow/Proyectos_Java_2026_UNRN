package ar.unrn.observer.ejercicio1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigConfiguracion {
    private final Properties properties = new Properties();

    public ConfigConfiguracion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Disculpá, no se pudo encontrar config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String obtenerUrlClima() {
        return properties.getProperty("weather.url");
    }
}