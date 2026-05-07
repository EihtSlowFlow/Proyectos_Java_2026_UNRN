package ar.unrn.tp5.ejercicio1;

import java.util.List;

public class MandoMedio implements EmpleadoInterface {
    private final double SUELDO = 50000;
    List<EmpleadoInterface> lideresDeProyecto;
    private final String nombre;
    private final String apellido;

    public MandoMedio(List<EmpleadoInterface> lideresDeProyecto, String nombre, String apellido) {
        this.lideresDeProyecto = lideresDeProyecto;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    @Override
    public double calcularSueldoSubordinados() {
        double salida = SUELDO;
        System.out.println("Se sumo " + SUELDO + " de " + this.nombre + this.apellido + ". (Mando Medio)");
        for (EmpleadoInterface empleado : lideresDeProyecto) {
            salida += empleado.calcularSueldoSubordinados();
        }
        return salida;
    }
}
