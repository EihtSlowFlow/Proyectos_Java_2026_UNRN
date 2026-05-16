package ar.unrn.tp5.ejercicio3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteSimple implements Reporte {

    private String reporte;

    public ReporteSimple(String reporte) {
        this.reporte = reporte;
    }

    @Override
    public void export(File file) throws IOException {
        System.out.println("Entró al export simple");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(this.reporte + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar los datos: " + e.getMessage());
        }
    }
}