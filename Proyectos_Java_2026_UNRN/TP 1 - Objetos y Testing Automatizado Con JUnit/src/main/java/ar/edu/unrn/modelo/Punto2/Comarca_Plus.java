package ar.edu.unrn.modelo.Punto2;

public class Comarca_Plus implements Tarjeta {
    /*DESCUENTO DEL 2% SOBRE EL TOTAL DEL PEDIDO*/
    @Override
    public double aplicarDescuento(Pedido pedido) {
        double montoDescontado;
        return montoDescontado = pedido.calcularTotal() * 0.02;
    }
}
