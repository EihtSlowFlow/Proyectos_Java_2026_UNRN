package ar.unrn.tp5.ejercicio5;

public class RemeraNacional extends Remera {
    final double IMPUESTO_NACIONAL = 0.015;
    final double BONIFICACION = 0.20;

    public RemeraNacional(double precio) {
        super(precio);
    }


    @Override
    protected double impuestoYRecargoParticular() {
        return IMPUESTO_NACIONAL;
    }

    @Override
    protected double impuestoYBonificacionParticular() {
        return BONIFICACION;
    }

}
