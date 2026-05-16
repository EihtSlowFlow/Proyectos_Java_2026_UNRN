package ar.unrn.tp4_1.ejercicio3;

public class Seguro implements SeguroInterface {

    private final TipoSeguro tipo;
    private final double costo;

    public Seguro(TipoSeguro tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    @Override
    public double calcularCosto() {
        return costo;
    }

    @Override
    public int contarSeguros() {
        return 1;
    }

}
