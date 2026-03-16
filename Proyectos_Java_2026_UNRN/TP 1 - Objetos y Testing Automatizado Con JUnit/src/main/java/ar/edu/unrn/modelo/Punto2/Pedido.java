package ar.edu.unrn.modelo.Punto2;


import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Consumible> consumibles;
    /// Declarando
    private final Tarjeta tarjeta;
    private double costoPlatos;
    private double costoBebidas;


    public Pedido(List<Consumible> consumibles, Tarjeta tarjeta) {
        // Hacemos una copia de la lista para proteger el encapsulamiento
        // Así, si alguien quiere cambiar la lista desde fuera, no rompe nuestro pedido
        this.consumibles = new ArrayList<>(consumibles);
        if (tarjeta != null) {
            this.tarjeta = tarjeta;
        } else {
            throw new IllegalArgumentException("La tarjeta no puede ser nula");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Consumible consumible : consumibles) {
            total += consumible.precio();
        }
        return total;
    }

    public double calcularTotalConDescuento() {
        double total = calcularTotal();
        if (tarjeta != null) {
            total -= tarjeta.aplicarDescuento(this);

        }
        return total;
    }

    public double calcularMontoPropina(double porcentaje) {
        // La propina se calcula sobre el total ya descontado
        /// Dividimos el porcentaje por 100 para convertirlo a decimal, así no es tan "robusto" en la especificidad del porcentaje.
        return calcularTotalConDescuento() * (porcentaje / 100.0);
    }

    public double calcularTotalFinal(double porcentajePropina) {
        return calcularTotalConDescuento() + calcularMontoPropina(porcentajePropina);
    }


    public double getCostoPlatos() {
        double costo = 0.0;
        for (Consumible consumible : consumibles) {
            costo += consumible.precioSiEsPlato();
        }
        return costo;
    }

    public double getCostoBebidas() {
        double costo = 0.0;
        for (Consumible consumible : consumibles) {
            costo += consumible.precioSiEsBebida();
        }
        return costo;
    }

    public String finalizarPedido(double porcentajePropina) {
        return String.format(
                "Resumen de Cuenta:\n" +
                        "------------------\n" +
                        "Subtotal Bruto:   $%.2f\n" +
                        "Descuento Aplicado: -$%.2f\n" +
                        "Propina (%d%%):     $%.2f\n" +
                        "------------------\n" +
                        "TOTAL FINAL:      $%.2f",
                calcularTotal(),
                tarjeta.aplicarDescuento(this),
                (int) porcentajePropina,
                calcularMontoPropina(porcentajePropina),
                calcularTotalFinal(porcentajePropina)
        );
    }

}
