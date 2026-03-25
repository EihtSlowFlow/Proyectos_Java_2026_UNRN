package ar.edu.unrn.modelo.Punto2;

public class TarjetaSinDescuento implements Tarjeta {

    @Override
    // ¿realmente necesario?
    public void iniciarProcesamiento() {
    }

    public void descontarBebida(double precio) {
    }

    public void descontarPlato(double precio) {
    }

    public double totalDescuentoAcumulado() {
        return 0;
    }
}
