package ar.edu.unrn.modelo.Punto2;

public class Bebida implements Consumible {
    private final double precio;
    private final String Nombre;

    public Bebida(double precio, String nombre) {
        this.precio = precio;
        this.Nombre = nombre;
    }

    ///  Valor intrinseco --> identidad del objeto.
    @Override
    public double precio() {
        return this.precio;
    }

    @Override
    public Categoria categoria() {
        return Categoria.BEBIDA;
    }
}
