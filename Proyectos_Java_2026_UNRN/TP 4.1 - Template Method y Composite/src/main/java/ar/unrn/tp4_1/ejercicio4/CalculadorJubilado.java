package ar.unrn.tp4_1.ejercicio4;

import static java.time.LocalDate.now;

public class CalculadorJubilado extends Calculador {

    public CalculadorJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }

    @Override
    public double recargoMesPromocion(double precioProducto) {
        return 0;
    }

    @Override
    public double recargoFueraMesPromocion(double precioProducto) {
        return precioProducto * 0.1;
    }
}
