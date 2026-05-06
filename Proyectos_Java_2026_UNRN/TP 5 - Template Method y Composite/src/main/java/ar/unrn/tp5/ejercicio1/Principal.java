package ar.unrn.tp5.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        EmpleadoInterface empleado;
        empleado = new EmpleadoRegular("Juan", "Perez");
        EmpleadoInterface empleado2 = new EmpleadoRegular("Jorge", "Perez");
        EmpleadoInterface empleado3 = new EmpleadoRegular("Manuel", "Perez");
        List<EmpleadoInterface> empleados = new ArrayList<>();
        empleados.add(empleado);
        empleados.add(empleado2);
        empleados.add(empleado3);
        EmpleadoInterface liderProyecto = new LiderDeProyecto(empleados, "Joao", "Treis Santos");
        EmpleadoInterface empleado5;
        empleado5 = new EmpleadoRegular("Matt", "Groening");
        EmpleadoInterface empleado6 = new EmpleadoRegular("Marge", "Bouvier");
        EmpleadoInterface empleado7 = new EmpleadoRegular("Svetlana", "Ancelotti");
        List<EmpleadoInterface> empleados2 = new ArrayList<>();
        empleados2.add(empleado5);
        empleados2.add(empleado6);
        empleados2.add(empleado7);

        EmpleadoInterface liderProyecto2 = new LiderDeProyecto(empleados2, "Joao", "Treis Santos");

        ArrayList<EmpleadoInterface> lideresProyecto = new ArrayList<>();
        lideresProyecto.add(liderProyecto);
        lideresProyecto.add(liderProyecto2);
        EmpleadoInterface mandoMedio = new MandoMedio(lideresProyecto,"Joao","Gilberto");
        ArrayList<EmpleadoInterface> mandosMedios = new ArrayList<>();
        mandosMedios.add(mandoMedio);
        mandosMedios.add(new MandoMedio(new ArrayList<>(), "Maria", "Gilberto"));

        EmpleadoInterface gerente = new Gerente(mandosMedios, "Joao", "Quadro Santos");

        // EmpleadoInterface director = new Director(empleados2, "Joao", "Treis Santos");

        System.out.println(gerente.calcularSueldoSubordinados());
    }
}
