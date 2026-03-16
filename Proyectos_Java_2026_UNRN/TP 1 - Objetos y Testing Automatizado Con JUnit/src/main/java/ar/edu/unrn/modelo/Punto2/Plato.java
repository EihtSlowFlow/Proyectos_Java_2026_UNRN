package ar.edu.unrn.modelo.Punto2;

public class Plato implements Consumible {
    private final double precio;
    private final String Nombre;

    public Plato(double precio, String nombre) {
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
        return 0;
    }

    @Override
    public double precioSiEsPlato() {
        return precio;
    }
}
