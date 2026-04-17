package ar.edu.unrn.modelo.Punto2;


import java.util.Map;

public class Comarca_Plus implements Tarjeta {
    /*DESCUENTO DEL 2% SOBRE EL TOTAL DEL PEDIDO*/
    /*
    private final Map<Categoria, Double> reglasDescuento = Map.of(
            Categoria.PLATO, 0.02,
            Categoria.BEBIDA, 0.02
            // Los platos no están en el mapa, así que devolverán 0 por defecto
    );

     */

    @Override
    public double calcularDescuento(Categoria categoria, double precio) {
        /// getOrDefault --> O te trae la categoria con su descuento asociado o devuelve directamente 0
        // double porcentaje = reglasDescuento.getOrDefault(categoria, 0.0);
        return precio * 0.02;
    }
}
