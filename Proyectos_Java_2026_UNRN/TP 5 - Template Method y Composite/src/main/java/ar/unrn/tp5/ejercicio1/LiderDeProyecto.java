package ar.unrn.tp5.ejercicio1;

import java.util.List;

public class LiderDeProyecto implements EmpleadoInterface {
    private final double SUELDO = 30000;
    List<EmpleadoInterface> empleadosRegulares;
    private final String nombre;
    private final String apellido;

    public LiderDeProyecto(List<EmpleadoInterface> empleadosRegulares, String nombre, String apellido) {
        this.empleadosRegulares = empleadosRegulares;
        this.nombre = nombre;
        this.apellido = apellido;

    }


    @Override
    public double calcularSueldoSubordinados() {
        System.out.println("Se sumo " + SUELDO + " de " + this.nombre + this.apellido + ". (Lider de Proyecto)");
        double salida = SUELDO;
        for (EmpleadoInterface empleado : empleadosRegulares) {
            salida += empleado.calcularSueldoSubordinados();
        }
        return salida;
    }

}
