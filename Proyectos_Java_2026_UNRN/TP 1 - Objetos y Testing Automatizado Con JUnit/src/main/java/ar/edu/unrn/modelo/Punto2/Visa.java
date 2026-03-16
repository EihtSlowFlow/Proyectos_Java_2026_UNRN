package ar.edu.unrn.modelo.Punto2;

public class Visa implements Tarjeta {
    /*DESCUENTO DE 3% SOBRE LAS BEBIDAS*/

    @Override
    public double aplicarDescuento(Pedido pedido) {
        double montoDescontado;
        return montoDescontado = pedido.getCostoBebidas() * 0.03;
    }
}
