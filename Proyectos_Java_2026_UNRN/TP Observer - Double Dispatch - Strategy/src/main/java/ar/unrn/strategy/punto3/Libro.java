package ar.unrn.strategy.punto3;

public class Libro implements CalculadoraPrecioPorTipo {

    @Override
    public double determinarImpuesto(Producto producto) {
        return 0.1;
    }

    @Override
    public boolean determinarEnvioGratis(Producto producto) {
        return producto.precio > 100;
    }

    @Override
    public double determinarDescuento(Producto producto) {
        return 0.1;
    }
}
