package ar.unrn.tp5.ejercicio3;

import java.io.File;
import java.io.IOException;

public class ReportSinSobreescritura implements Reporte{
    Reporte report;
    public ReportSinSobreescritura(Reporte report) {
        this.report = report;
    }
    @Override
    public void export(File file) throws IOException {
        System.out.println("Entró al reporte sin sobreescritura");
        if (file == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }
        if (file.exists()) {
            throw new IllegalArgumentException("El archivo ya existe...");
        }
        System.out.println("Se validó el file en sin sobreescritura");
        report.export(file);
    }
}
