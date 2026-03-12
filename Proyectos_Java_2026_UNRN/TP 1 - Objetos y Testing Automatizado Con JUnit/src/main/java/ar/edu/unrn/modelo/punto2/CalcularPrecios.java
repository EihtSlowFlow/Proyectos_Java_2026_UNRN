package ar.edu.unrn.modelo.punto2;

public class CalcularPrecios {

    // Constantes para los tipos de tarjeta
    public static final String VISA = "VISA";
    public static final String MASTERCARD = "MASTERCARD";
    public static final String COMARCA_PLUS = "COMARCA_PLUS";

    public double calcularDescuentoTarjeta(String tipoTarjeta, double costoBebidas, double costoPlatosPrincipales) {
        /// Switch simplificado, sugerido por el IDE
        double descuento = switch (tipoTarjeta.toUpperCase()) {
            case VISA -> costoBebidas * 0.03; // 3% sobre bebidas
            case MASTERCARD -> costoPlatosPrincipales * 0.02; // 2% sobre platos principales
            case COMARCA_PLUS -> {
                double costoTotal = costoBebidas + costoPlatosPrincipales;
                ///  el yield se utiliza cuando el case tiene más de una unica línea de codigo
                yield costoTotal * 0.02;
            }
            default -> 0.0; // Sin descuento para otras tarjetas
        };

        return descuento;
    }

    public double calcularPropina(double costoTotal, double porcentajePropina) {
        if (porcentajePropina != 0.02 && porcentajePropina != 0.03 && porcentajePropina != 0.05) {
            throw new IllegalArgumentException("La propina debe ser 2%, 3% o 5%");
        }
        return costoTotal * porcentajePropina;
    }


    public double calcularCostoFinal(double costoBebidas, double costoPlatosPrincipales, String tipoTarjeta, double porcentajePropina) {
        double costoSubtotal = costoBebidas + costoPlatosPrincipales;
        double descuento = calcularDescuentoTarjeta(tipoTarjeta, costoBebidas, costoPlatosPrincipales);
        double costoConDescuento = costoSubtotal - descuento;
        double propina = calcularPropina(costoConDescuento, porcentajePropina);

        return costoConDescuento + propina;
    }

    public double getDescuentoVisa(double costoBebidas) {
        return costoBebidas * 0.03;
    }

    public double getDescuentoMastercard(double costoPlatosPrincipales) {
        return costoPlatosPrincipales * 0.02;
    }

    public double getDescuentoComarcaPlus(double costoTotal) {
        return costoTotal * 0.02;
    }
}
