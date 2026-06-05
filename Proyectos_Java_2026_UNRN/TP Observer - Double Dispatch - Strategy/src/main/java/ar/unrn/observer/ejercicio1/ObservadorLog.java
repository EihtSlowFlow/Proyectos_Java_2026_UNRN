package ar.unrn.observer.ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ObservadorLog implements Observer {
    private final String PATH = "/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP Observer - Double Dispatch - Strategy/src/main/java/ar/unrn/observer/ejercicio1/ObserverLOG.txt";
    File file = new File(PATH);

    @Override
    public void actualizarTemperatura(String temperatura) {
        LocalDateTime fechaDeActualizacion = LocalDateTime.now();
        String fechaFinal = fechaDeActualizacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(temperatura + " - " + fechaFinal + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el log: " + e.getMessage());
        }
    }
}
