package ar.edu.unrn.modelo.Punto2;

public class MasterCard implements Tarjeta {
    /*DESCUENTO DE 2% SOBRE LOS PLATOS PRINCIPALES*/
    @Override
    public double aplicarDescuento(Pedido pedido) {
        double montoDescontado;
        return montoDescontado = pedido.getCostoPlatos() * 0.02;
    }
}
