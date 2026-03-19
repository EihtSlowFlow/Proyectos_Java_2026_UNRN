package ar.edu.unrn.modelo.Punto2;


import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Consumible> consumibles;
    /// Declarando
    private final Tarjeta tarjeta;


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
        // TELL: Le decimos a la tarjeta que se prepare
        /// Despeja los valores anteriores para iniciar en 0
        tarjeta.iniciarProcesamiento();

        double bruto = this.calcularTotal();

        // Doble despacho --> (el primer despacho): el JVM decide qué computarDescuento ejecutar basándose en el Consumible
        // (segundo despacho): Dentro del método el objeto ejecuta tarjeta.descontarBebida( this.precio). En este punto
        // el compilador sabe que tiene que llamar a descontarBebida() porque el código esta escrito dentro de la clase Bebida()


        /// La JVM se encarga de llamar al método correcto según el tipo real del consumible (plato o bebida)
        /// ya que ambos implementan la interfaz Consumible, pero cada uno tiene su propia lógica de descuento en el método computarDescuento
        for (Consumible c : consumibles) {
            c.computarDescuento(this.tarjeta);
        }

        // Devolvemos el total restando el acumulado limpio
        return bruto - tarjeta.totalDescuentoAcumulado();
    }

    public double calcularMontoPropina(double porcentaje) {
        // La propina se calcula sobre el total ya descontado
        /// Dividimos el porcentaje por 100 para convertirlo a decimal, así no es tan "robusto" en la especificidad del porcentaje.
        return calcularTotalConDescuento() * (porcentaje / 100.0);
    }

    public double calcularTotalFinal(double porcentajePropina) {
        return calcularTotalConDescuento() + calcularMontoPropina(porcentajePropina);
    }

    public String finalizarPedido(double porcentajePropina) {
        double bruto = calcularTotal();
        double conDescuento = calcularTotalConDescuento();
        double descuentoAplicado = bruto - conDescuento;
        double montoPropina = calcularMontoPropina(porcentajePropina);
        double totalFinal = conDescuento + montoPropina;

        return String.format(
                "Resumen de Cuenta:\n" +
                        "------------------\n" +
                        "Subtotal Bruto:   $%.2f\n" +
                        "Descuento Aplicado: -$%.2f\n" +
                        "Propina (%d%%):     $%.2f\n" +
                        "------------------\n" +
                        "TOTAL FINAL:      $%.2f",
                bruto,
                descuentoAplicado,
                (int) porcentajePropina,
                montoPropina,
                totalFinal
        );
    }

}
