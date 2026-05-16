package ar.unrn.tp4_1.ejercicio5;

public abstract class Remera {
    private double precio;

    public Remera(double precio) {
        this.precio = precio;
    }

    public final double calcularPrecio(){
        double precioFinal = precio;
        precioFinal += precio * impuestoYRecargoParticular();
        precioFinal -= precio * impuestoYBonificacionParticular();
        return precioFinal;
    }
    protected abstract double impuestoYRecargoParticular();
    protected abstract double impuestoYBonificacionParticular();

}
