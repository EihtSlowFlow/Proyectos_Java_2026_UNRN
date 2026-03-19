package ar.edu.unrn.modelo.Punto2;

public class MasterCard implements Tarjeta {
    /*DESCUENTO DE 2% SOBRE LOS PLATOS PRINCIPALES*/
    private double descuento = 0;

    public void iniciarProcesamiento() {
        this.descuento = 0;
    }

    @Override
    public void descontarBebida(double precio) {
    }

    @Override
    public void descontarPlato(double precio) {
        this.descuento += precio * 0.02;
    }

    @Override
    public double totalDescuentoAcumulado() {
        return this.descuento;
    }
}

