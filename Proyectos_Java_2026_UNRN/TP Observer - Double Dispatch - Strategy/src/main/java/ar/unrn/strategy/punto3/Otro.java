package ar.unrn.strategy.punto3;

public class Otro implements CalculadoraPrecioPorTipo {
    @Override
    public double determinarImpuesto(Producto producto) {
        return 0.15;
    }

    @Override
    public boolean determinarEnvioGratis(Producto producto) {
        return producto.precio > 200;
    }

    @Override
    public double determinarDescuento(Producto producto) {
        if (producto.precio > 50) {
            return 0.05;
        }
        return 0;
    }
}
