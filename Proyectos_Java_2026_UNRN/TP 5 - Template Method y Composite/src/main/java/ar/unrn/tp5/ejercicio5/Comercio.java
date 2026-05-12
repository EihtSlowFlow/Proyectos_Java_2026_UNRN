package ar.unrn.tp5.ejercicio5;

public class Comercio {
    double recargo;
    public Comercio(double recargo) {
        this.recargo = recargo;
    }
        public double calcularPrecioFinal(Remera remera){
        double precioFinal = 0;
        double precioRemera = remera.calcularPrecio();
        double subtotal = precioRemera * recargo;
        precioFinal += subtotal + precioRemera;
        return precioFinal;
        }
}
