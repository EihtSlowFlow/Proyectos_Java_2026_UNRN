package ar.edu.unrn.modelo.Punto2;

public class FileExportInMemory implements Export {
    private final StringBuilder registro = new StringBuilder();

    @Override
    public void exportar(String datosEntrada) {
        this.registro.append(datosEntrada).append(System.lineSeparator());
    }

    public String datos() {
        return this.registro.toString();
    }
}
