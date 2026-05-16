package ar.unrn.tp4_1.ejercicio1;

import java.util.List;

public class EmpleadoConGenteACargo implements EmpleadoInterface{
    private List<EmpleadoInterface> subordinados;
    private final double SUELDO;
    private ROL rol;
    public EmpleadoConGenteACargo(double SUELDO,  List<EmpleadoInterface> subordinados, ROL rolEx){
        this.SUELDO = SUELDO;
        this.subordinados = subordinados;
        this.rol = rolEx;
    }


    @Override
    public double calcularSueldoSubordinados() {
        double totalIntermedio = SUELDO;
        for (EmpleadoInterface subordinado : subordinados) {
            totalIntermedio += subordinado.calcularSueldoSubordinados();
            System.out.println("Se sumo " + subordinado.calcularSueldoSubordinados() + " de un subordinado de " + this.rol + ".(Empleado con gente a cargo)");
        }
        return totalIntermedio;
    }
}

