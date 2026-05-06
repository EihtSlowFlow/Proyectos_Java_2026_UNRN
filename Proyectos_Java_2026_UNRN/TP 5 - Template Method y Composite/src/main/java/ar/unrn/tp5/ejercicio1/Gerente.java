package ar.unrn.tp5.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Gerente implements EmpleadoInterface {
    private final int SUELDO = 70000;
    List<EmpleadoInterface> MandoMedio;
    private final String nombre;
    private final String apellido;

    public Gerente(List<EmpleadoInterface> mandoMedio, String nombre, String apellido) {
        this.MandoMedio = mandoMedio;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public double calcularSueldoSubordinados() {
        double salida = SUELDO;
        System.out.println("Se sumo " + SUELDO + " de " + this.nombre + this.apellido + ". (Gerente)");
        for (EmpleadoInterface MandoMedio : MandoMedio) {
            salida += MandoMedio.calcularSueldoSubordinados();
        }
        return salida;
    }
}
