package ar.unrn.tp5.ejercicio3;

import java.io.File;
import java.io.IOException;

public class ReportConSobreescritura implements Reporte{
    Reporte report;
    public ReportConSobreescritura(Reporte report) {
        this.report = report;
    }
    @Override
    public void export(File file) throws IOException {
        System.out.println("Entró al export con sobreescritura");
        if (file == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        System.out.println("Se validó el file con sobreescritura");
        report.export(file);
    }
}
