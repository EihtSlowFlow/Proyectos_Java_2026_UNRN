package ar.edu.unrn.modelo.Punto2;

public interface Tarjeta {
    // Recibe los datos y devuelve el descuento a aplicar
    double calcularDescuento(Categoria categoria, double precio);
}