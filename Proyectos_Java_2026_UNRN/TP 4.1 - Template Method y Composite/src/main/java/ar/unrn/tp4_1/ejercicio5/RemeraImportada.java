package ar.unrn.tp4_1.ejercicio5;

public class RemeraImportada extends Remera {
    final double IMPUESTO_ADUANA = 0.05;
    final double RECARGO = 0.03;


    public RemeraImportada(double precio) {
        super(precio);
    }

    @Override
    protected double impuestoYRecargoParticular() {
        return IMPUESTO_ADUANA + RECARGO;
    }

    @Override
    protected double impuestoYBonificacionParticular() {
        return 0;
    }
}
