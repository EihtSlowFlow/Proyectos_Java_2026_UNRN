package ar.edu.unrn.modelo.Punto2;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Pedido {
    private final Export export;
    private final List<Consumible> consumibles;
    private final Supplier<Tarjeta> tarjetaSupplier;
    private final Supplier<LocalDateTime> timeSupplier;
    private final LocalDateTime fechaActual; // Para simular el paso del tiempo en tests
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Pedido(List<Consumible> consumibles, Export export, Supplier<Tarjeta> tarjetaSupplier, Supplier<LocalDateTime> timeSup) {
        // Hacemos una copia de la lista para proteger el encapsulamiento
        // Así, si alguien quiere cambiar la lista desde fuera, no rompe nuestro pedido
        this.consumibles = new ArrayList<>(consumibles);
        if (tarjetaSupplier != null)
            this.tarjetaSupplier = tarjetaSupplier;
        else
            throw new RuntimeException("Todo mal con el supplier");
        this.export = export;
        this.timeSupplier = timeSup;
        this.fechaActual = LocalDateTime.now();
    }

    public Pedido(List<Consumible> consumibles, Supplier<Tarjeta> tarjetaSupplier) {
        this.consumibles = new ArrayList<>(consumibles);
        if (tarjetaSupplier != null)
            this.tarjetaSupplier = tarjetaSupplier;
        else
            throw new RuntimeException("Todo mal con el supplier");
        export = null;
        this.fechaActual = LocalDateTime.now();
        this.timeSupplier = null;
    }


    public double calcularTotal() {
        double total = 0.0;
        for (Consumible consumible : consumibles) {
            total += consumible.precio();
        }
        return total;
    }

    public double calcularTotalConDescuento() {
        double bruto = this.calcularTotal();
        double totalDescuento = 0.0;
        /// Se cambió el metodo iniciarProcesamiento por un supplier, resulta más elegante y cumple la función.
        Tarjeta tp = tarjetaSupplier.get();

        // Se usa una tarjeta sin restos de calculos anteriores
        for (Consumible c : consumibles) {
            totalDescuento += tp.calcularDescuento(c.categoria(), c.precio());
        }

        // Devolvemos el total restando el acumulado limpio
        return bruto - totalDescuento;

    }

    public double calcularMontoPropina(double porcentaje) {
        // La propina se calcula sobre el total ya descontado
        /// Dividimos el porcentaje por 100 para convertirlo a decimal, así no es tan "robusto" en la especificidad del porcentaje.
        return calcularTotalConDescuento() * (porcentaje / 100.0);
    }

    public double calcularTotalFinal(double porcentajePropina) {
        return calcularTotalConDescuento() + calcularMontoPropina(porcentajePropina);
    }


    private String toCSV(double porcentajePropina) {

        StringBuilder sb = new StringBuilder();

        String fechaHoraFormateada = this.timeSupplier.get().format(FORMATO_FECHA);
        double totalFinal = this.calcularTotalFinal(porcentajePropina);

        sb.append(String.format("%s || %.2f%n", fechaHoraFormateada, totalFinal));

        return sb.toString();
    }

    public String finalizarPedido(double porcentajePropina) {
        double bruto = calcularTotal();
        double conDescuento = calcularTotalConDescuento();
        double descuentoAplicado = bruto - conDescuento;
        double montoPropina = calcularMontoPropina(porcentajePropina);
        double totalFinal = conDescuento + montoPropina;
        if (this.export != null)
            this.export.exportar(toCSV(porcentajePropina));

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
    /*
    // Uso exclusivo para los tests.
    public void setFechaActual(LocalDateTime fecha) {
        this.fechaActual = fecha;
    }
    */

}
