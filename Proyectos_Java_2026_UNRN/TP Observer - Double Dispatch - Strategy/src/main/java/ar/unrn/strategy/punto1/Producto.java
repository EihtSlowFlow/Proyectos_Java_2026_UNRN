package ar.unrn.strategy.punto1;

public class Producto {
    double pesoKG;
    double pesoG;
    String descripcion;
    double precioProducto;
    public Producto(double pesoKG, double pesoG, String descripcion, double precioProducto) {
        if (pesoKG < 0 || pesoG < 0) {
            throw new RuntimeException("No se permiten valores negativos");
        }
        this.pesoKG = pesoKG;
        this.pesoG = pesoG;
        this.descripcion = descripcion;
        this.precioProducto = precioProducto;
    }
    double Peso() {
        return pesoKG + (pesoG / 1000);
    }
    double Precio() {
        return precioProducto;
    }

}
