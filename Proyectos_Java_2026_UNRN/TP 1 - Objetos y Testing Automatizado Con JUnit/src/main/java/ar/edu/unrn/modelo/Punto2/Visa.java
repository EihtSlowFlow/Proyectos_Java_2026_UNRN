package ar.edu.unrn.modelo.Punto2;


public class Visa implements Tarjeta {
    /*DESCUENTO DE 3% SOBRE LAS BEBIDAS*/
    private double descuento = 0;

    public void iniciarProcesamiento() {
        // Borramos el rastro de cálculos anteriores
        this.descuento = 0;
    }

    @Override
    public void descontarBebida(double precio) {
        // 3% sobre las bebidas
        this.descuento += precio * 0.03;
    }

    @Override
    public void descontarPlato(double precio) {
        // Visa no descuenta platos
    }

    @Override
    public double totalDescuentoAcumulado() {
        return this.descuento;
    }
}

