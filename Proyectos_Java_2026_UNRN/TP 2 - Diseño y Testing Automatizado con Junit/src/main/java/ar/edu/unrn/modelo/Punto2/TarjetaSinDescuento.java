package ar.edu.unrn.modelo.Punto2;

public class TarjetaSinDescuento implements Tarjeta {
    
    @Override
    public double calcularDescuento(Categoria categoria, double precio) {
        return 0;
    }
}
