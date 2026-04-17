package ar.edu.unrn.modelo.Punto2;

import java.util.Map;

public class Visa implements Tarjeta {
    // Crea el mapa que responde a una Categoria con un porcentaje que en este caso representa el descuento.
    /// Es como una tabla de dos elementos, busca la clave (categoria) y devuelve su unica ocurrencia (descuento, double)
    /// en este caso, la declaracion, solo se le asigna valor a reglasDescuento según el tipo de categoria que vuelva
    /// si resulta en plato, el getOrDefault posterior retorna 0, caso contrario devolverá 0.03
    private final Map<Categoria, Double> reglasDescuento = Map.of(
            Categoria.BEBIDA, 0.03
            // Los platos no están en el mapa, así que devolverán 0 por defecto
    );

    @Override
    public double calcularDescuento(Categoria categoria, double precio) {
        /// getOrDefault --> O te trae la categoria con su descuento asociado o devuelve directamente 0
        double porcentaje = reglasDescuento.getOrDefault(categoria, 0.0);
        return precio * porcentaje;
    }
}


