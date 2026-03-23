package ar.edu.unrn.modelo.Punto1;

public class EnMemoriaExport implements Export {
    private final StringBuilder registro = new StringBuilder();

    @Override
    public void exportar(String datosEntrada) {
        this.registro.append(datosEntrada).append(System.lineSeparator());
    }

    public String datos() {
        return this.registro.toString();
    }
}