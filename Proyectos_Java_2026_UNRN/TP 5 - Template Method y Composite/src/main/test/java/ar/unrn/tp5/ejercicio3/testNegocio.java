package ar.unrn.tp5.ejercicio3;
import ar.unrn.tp5.ejercicio5.Comercio;
import ar.unrn.tp5.ejercicio5.Remera;
import ar.unrn.tp5.ejercicio5.RemeraImportada;
import ar.unrn.tp5.ejercicio5.RemeraNacional;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testNegocio {

    @Test
    public void testCalcularPrecioFinalRemeraNacional() {

        Comercio comercio = new Comercio(0.10);
        Remera nacional = new RemeraNacional(100);

        double precioFinal = comercio.calcularPrecioFinal(nacional);

        double resultadoEsperado = 89.65;
        assertEquals(resultadoEsperado, precioFinal, 0.001);
    }

    @Test
    public void testCalcularPrecioFinalRemeraImportada() {

        Comercio comercio = new Comercio(0.20);
        Remera importada = new RemeraImportada(100);

        double precioFinal = comercio.calcularPrecioFinal(importada);

        double resultadoEsperado = 129.6;
        assertEquals(resultadoEsperado, precioFinal, 0.001);
    }
}