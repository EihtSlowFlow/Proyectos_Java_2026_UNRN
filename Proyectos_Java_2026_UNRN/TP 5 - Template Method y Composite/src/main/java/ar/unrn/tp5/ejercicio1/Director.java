package ar.unrn.tp5.ejercicio1;

import java.util.List;

public class Director implements EmpleadoInterface {
    private final double SUELDO = 99999;
    List<EmpleadoInterface> gerentes;
    private final String nombre;
    private final String apellido;

    public Director(List<EmpleadoInterface> gerentes, String nombre, String apellido) {
        this.gerentes = gerentes;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    @Override
    public double calcularSueldoSubordinados() {
        double salida = SUELDO;
        System.out.println("Se sumo " + SUELDO + " de " + this.nombre + this.apellido + ".(Director)");
        for (EmpleadoInterface empleado : this.gerentes) {
            salida += empleado.calcularSueldoSubordinados();
        }
        return salida;
    }
}
