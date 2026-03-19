package ar.edu.unrn.modelo.Punto2;


public class Comarca_Plus implements Tarjeta {
    /*DESCUENTO DEL 2% SOBRE EL TOTAL DEL PEDIDO*/
    /* Ejemplo: Descuento del 2% sobre el total (bebidas y platos) */
    private double descuentoAcumulado = 0;

    public void iniciarProcesamiento() {
        // Borramos el rastro de cálculos anteriores
        this.descuentoAcumulado = 0;
    }

    @Override
    public void descontarBebida(double precio) {
        // Lógica específica de Comarca Plus para bebidas
        this.descuentoAcumulado += precio * 0.02;
    }

    @Override
    public void descontarPlato(double precio) {
        // Lógica específica de Comarca Plus para platos
        this.descuentoAcumulado += precio * 0.02;
    }

    @Override
    public double totalDescuentoAcumulado() {
        return this.descuentoAcumulado;
    }
}
