package ar.unrn.tp4_1.ejercicio4;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class Calculador {
    private final LogTransaction log;
    private final int mesEnPromocion;
    public Calculador(LogTransaction log, int mesEnPromocion) {
        this.log = log;
        this.mesEnPromocion = mesEnPromocion;
    }

    public final double calcularPrecio(double precioProducto){
        double precioFinal = precioProducto;
        if(mesConDescuento(mesEnPromocion)){
           precioFinal+= recargoMesPromocion(precioProducto);
        }else{
            precioFinal+= recargoFueraMesPromocion(precioProducto);
        }
        log.log(this.getClass().getName());
        return precioFinal;
    }

    private static boolean mesConDescuento(int mesEnPromocion) {
        return of(mesEnPromocion).equals(now().getMonth());
    }
    public abstract double recargoMesPromocion(double precioProducto);
    public abstract double recargoFueraMesPromocion(double precioProducto);
}
