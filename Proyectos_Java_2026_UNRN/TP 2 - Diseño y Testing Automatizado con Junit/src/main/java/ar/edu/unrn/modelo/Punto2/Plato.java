package ar.edu.unrn.modelo.Punto2;

public class Plato implements Consumible {
    private final double precio;
    private final String Nombre;

    public Plato(double precio, String nombre) {
        this.precio = precio;
        this.Nombre = nombre;
    }

    ///  Valor intrinseco --> identidad del objeto.
    @Override
    public double precio() {
        return this.precio;
    }
    
    @Override
    public String toString() {
        // Retornamos el atributo donde guardás el nombre del plato
        return this.Nombre;
    }

    @Override
    public Categoria categoria() {
        return Categoria.PLATO;
    }


}
