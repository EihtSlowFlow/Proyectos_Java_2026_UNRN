package ar.edu.unrn.modelo.Punto2;

public class Bebida implements Consumible {
    private final double precio;
    private final String Nombre;

    public Bebida(double precio, String nombre) {
        this.precio = precio;
        this.Nombre = nombre;
    }

    @Override
    ///  Valor intrinseco --> identidad del objeto.
    public double precio() {
        return precio;
    }

    /// Valor del objeto en el contexto donde se utiliza.
    @Override
    public double precioSiEsBebida() {
        return precio;
    }

    @Override
    public double precioSiEsPlato() {
        return 0;
    }
}
