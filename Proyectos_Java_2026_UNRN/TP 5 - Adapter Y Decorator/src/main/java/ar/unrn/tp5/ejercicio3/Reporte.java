package ar.unrn.tp5.ejercicio3;

import java.io.File;
import java.io.IOException;

public interface Reporte {
    void export(File file) throws IOException;
}
