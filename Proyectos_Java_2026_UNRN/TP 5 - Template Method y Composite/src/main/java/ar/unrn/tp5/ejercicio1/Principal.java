package ar.unrn.tp5.ejercicio1;

import java.util.ArrayList;
import java.util.List;

/*
La empresa “Laser X” posee los siguientes roles de empleados: directores, gerentes,
mandos medios, líderes de proyecto y empleados regulares. Todos tienen gente a su
cargo, salvo los empleados regulares. Los directores tienen a su cargo gerentes, los
gerentes a mandos medios, los mandos medios a líderes de proyecto y éstos a
empleados regulares.
a)Implemente en Java el modelo de objetos para permitir calcular el monto total salarial
de la empresa utilizando el patrón Composite. Escriba dos casos de test.
 */


// Polimorfismo doble
public class Principal {
    public static void main(String[] args) {
        /// lista de empleados regulares
        List<EmpleadoInterface> empleados = new ArrayList<>();
        empleados.add(new EmpleadoRegular("Juanito", "um"));
        empleados.add(new EmpleadoRegular("Juanito", "dois"));
        empleados.add(new EmpleadoRegular("Juanito", "treis"));
        /// Lider de proyecto que tiene a esos empleados regulares
        EmpleadoConGenteACargo liderDeProyecto = new EmpleadoConGenteACargo(10000.0, empleados, ROL.LIDER_PROYECTO);
        /// Segunda lista de empleados
        List<EmpleadoInterface> empleados2 = new ArrayList<>();
        empleados.add(new EmpleadoRegular("Juanito", "cuatro"));
        empleados.add(new EmpleadoRegular("Juanito", "cinco"));
        empleados.add(new EmpleadoRegular("Juanito", "seis"));
        /// Otro lider de proyecto
        EmpleadoConGenteACargo otroLiderdeproyecto = new EmpleadoConGenteACargo(10000.0, empleados2, ROL.LIDER_PROYECTO);
        /// mando medio
        EmpleadoConGenteACargo mandoMedio = new EmpleadoConGenteACargo(20000, List.of(liderDeProyecto, otroLiderdeproyecto), ROL.MANDO_MEDIO);

        System.out.println("Empleados: " + mandoMedio.calcularSueldoSubordinados());
    }
}
