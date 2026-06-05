package ar.unrn.strategy.punto3;

public interface CalculadoraPrecioPorTipo {
    // double calcularPrecio(Producto producto);
    double determinarImpuesto(Producto producto);
    boolean determinarEnvioGratis(Producto producto);
    double determinarDescuento(Producto producto);
}
