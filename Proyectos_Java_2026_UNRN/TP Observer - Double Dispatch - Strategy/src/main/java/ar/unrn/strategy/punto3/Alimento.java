package ar.unrn.strategy.punto3;

public class Alimento implements CalculadoraPrecioPorTipo {

    @Override
    public double determinarImpuesto(Producto producto) {
    return 0.05;
    }

    @Override
    public boolean determinarEnvioGratis(Producto producto) {
        return producto.precio > 200;
    }

    @Override
    public double determinarDescuento(Producto producto) {
        if (producto.precio > 100) {
            return 0.15;
        }
        return 0;
    }
}
