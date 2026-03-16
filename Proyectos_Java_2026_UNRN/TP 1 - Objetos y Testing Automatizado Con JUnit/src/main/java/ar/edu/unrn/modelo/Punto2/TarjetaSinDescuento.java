package ar.edu.unrn.modelo.Punto2;

public class TarjetaSinDescuento implements Tarjeta {
    @Override
    public double aplicarDescuento(Pedido pedido) {
        double descuentoAplicado = 0;
        return descuentoAplicado = pedido.calcularTotal() * 0;
    }
}
