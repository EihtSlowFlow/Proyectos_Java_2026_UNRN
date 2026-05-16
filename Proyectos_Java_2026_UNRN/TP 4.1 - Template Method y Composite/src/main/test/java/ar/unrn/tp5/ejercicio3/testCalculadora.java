package ar.unrn.tp4_1.ejercicio3;

import ar.unrn.tp4_1.ejercicio4.Calculador;
import ar.unrn.tp4_1.ejercicio4.CalculadorJubilado;
import ar.unrn.tp4_1.ejercicio4.CalculadorNoJubilado;
import ar.unrn.tp4_1.ejercicio4.LogTransaction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testCalculadora {
    @Test
    public void testCalculosJubilado() {
        LogTransaction log = new LogTransaction() {
            @Override
            public void log(String className) {
                System.out.println("Log: " + className);
            }
        };
        Calculador calculadorJubilado = new CalculadorJubilado(log, 6);
        assertEquals(110.0, calculadorJubilado.calcularPrecio(100.0), 0.001);
    }
    @Test
    public void testCalculosNoJubilado() {
        LogTransaction log = new LogTransaction() {
            @Override
            public void log(String className) {
                System.out.println("Log: " + className);
            }
        };
        Calculador calculadorNoJubilado = new CalculadorNoJubilado(log, 6);
        assertEquals(121.0, calculadorNoJubilado.calcularPrecio(100.0), 0.001);
    }
}
