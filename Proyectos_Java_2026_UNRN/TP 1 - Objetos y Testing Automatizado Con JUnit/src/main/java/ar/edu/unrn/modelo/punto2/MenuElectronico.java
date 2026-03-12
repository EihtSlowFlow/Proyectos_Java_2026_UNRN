package ar.edu.unrn.modelo.punto2;

import java.util.ArrayList;

public class MenuElectronico {
    /// private final int cantBebidas = 0;
    /// private final int cantPlatos = 0;
    private final ArrayList<Consumible> platos = new ArrayList<>();
    private final ArrayList<Consumible> pedido = new ArrayList<>();

    public MenuElectronico() {
        /// Constructor con valores predeterminados
        platos.add(new Consumible("Milanesa con papas fritas", 1500, Consumible.Categoria.PLATO_PRINCIPAL));
        platos.add(new Consumible("Pizza con muzzarella", 1200, Consumible.Categoria.PLATO_PRINCIPAL));
        platos.add(new Consumible("Hamburguesa con queso", 1300, Consumible.Categoria.PLATO_PRINCIPAL));
        platos.add(new Consumible("Gaseosa de Cola", 1000, Consumible.Categoria.BEBIDA));
        platos.add(new Consumible("Agua Mineral", 800, Consumible.Categoria.BEBIDA));
    }

    public void realizarPedido(int numeroPlato) {
        try {
            if (numeroPlato < 1 || numeroPlato > platos.size()) {
                Consumible seleccionado = platos.get(numeroPlato - 1);
                pedido.add(seleccionado);
            }
        } catch (RuntimeException e) {
            System.err.println("Número de plato inválido. Por favor, seleccione un número entre 1 y " + platos.size());
        }
    }

    public double calcularTotalBebidas() {
        return pedido.stream()
                .filter(c -> c.categoria() == Consumible.Categoria.BEBIDA)
                .mapToDouble(Consumible::precio)
                .sum();
    }

    public double calcularTotalPlatosPrincipales() {
        return pedido.stream()
                .filter(c -> c.categoria() == Consumible.Categoria.PLATO_PRINCIPAL)
                .mapToDouble(Consumible::precio)
                .sum();
    }


    /// Muestra el resumen del pedido con descuentos y propina

    public void mostrarResumenPedido(String tipoTarjeta, double porcentajePropina) {
        double costoBebidas = calcularTotalBebidas();
        double costoPlatos = calcularTotalPlatosPrincipales();
        double subtotal = costoBebidas + costoPlatos;

        CalcularPrecios calculador = new CalcularPrecios();
        /// Calculo con tarjeta de credito
        double descuento = calculador.calcularDescuentoTarjeta(tipoTarjeta, costoBebidas, costoPlatos);
        double costoConDescuento = subtotal - descuento;
        double propina = calculador.calcularPropina(costoConDescuento, porcentajePropina);
        double total = costoConDescuento + propina;

        System.out.println("\n=== RESUMEN DEL PEDIDO ===");
        System.out.println("Bebidas: $" + String.format("%.2f", costoBebidas));
        System.out.println("Platos principales: $" + String.format("%.2f", costoPlatos));
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Descuento (" + tipoTarjeta + "): -$" + String.format("%.2f", descuento));
        System.out.println("Costo con descuento: $" + String.format("%.2f", costoConDescuento));
        System.out.println("Propina (" + (porcentajePropina * 100) + "%): +$" + String.format("%.2f", propina));
        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", total));
    }
}