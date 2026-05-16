package ar.unrn.tp4_1.ejercicio3;

import java.util.List;

public class PaqueteSeguros implements SeguroInterface {
    private final double DESCUENTO = 0.05;
    private final List<SeguroInterface> seguros;

    public PaqueteSeguros(List<SeguroInterface> seguros) {
        this.seguros = seguros;
    }

    public void agregarSeguro(SeguroInterface seguro){
        seguros.add(seguro);
    }

    @Override
    public double calcularCosto() {
        double segurosTotal = 0;
        for (SeguroInterface seguro : seguros) {
            segurosTotal += seguro.calcularCosto();
        }
        double descuentoCalculado = DESCUENTO * this.contarSeguros();
        /// Math.min -> sugerido por el IDE
        double descuentoFinal = Math.min(descuentoCalculado, 0.50);

        return segurosTotal - (segurosTotal *  descuentoFinal) ;
    }

    @Override
    public int contarSeguros() {
        int total = 0;
        for (SeguroInterface elemento : seguros) {
            total += elemento.contarSeguros();
        }
        return total;
    }
}
