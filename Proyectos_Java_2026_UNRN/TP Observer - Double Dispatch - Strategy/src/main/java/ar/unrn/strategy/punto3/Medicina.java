package ar.unrn.strategy.punto3;

public class Medicina implements CalculadoraPrecioPorTipo {
    @Override
    public double determinarImpuesto(Producto producto) {
        return 0;
    }

    @Override
    public boolean determinarEnvioGratis(Producto producto) {
        return producto.precio > 100;
    }

    @Override
    public double determinarDescuento(Producto producto) {
        if (producto.precio > 50) {
            return 0.1;
        }
        return 0;
    }
}
