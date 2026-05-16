package ar.unrn.tp4_1.ejercicio4;
import static java.time.LocalDate.now;

public class CalculadorNoJubilado extends Calculador {
    public CalculadorNoJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }


    @Override
    public double recargoMesPromocion(double precioProducto) {
        return precioProducto * 0.15;
    }

    @Override
    public double recargoFueraMesPromocion(double precioProducto) {
        return precioProducto * 0.21;
    }


}