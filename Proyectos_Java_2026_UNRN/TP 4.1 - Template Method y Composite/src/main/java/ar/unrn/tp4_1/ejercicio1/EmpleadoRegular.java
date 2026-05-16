package ar.unrn.tp4_1.ejercicio1;

public class EmpleadoRegular implements EmpleadoInterface {
    private final double SUELDO = 2000;
    private final String nombre;
    private final String apellido;

    public EmpleadoRegular(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public double calcularSueldoSubordinados() {
        System.out.println("Se sumo " + SUELDO + " de " + this.nombre + this.apellido + ".(Empleado Regular)");
        return SUELDO;
    }
}
