package ar.unrn.tp5.ejercicio3;

import ar.unrn.tp5.ejercicio1.EmpleadoInterface;
import ar.unrn.tp5.ejercicio1.EmpleadoRegular;
import ar.unrn.tp5.ejercicio1.EmpleadoConGenteACargo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestEmpresa {
    /*
    Todos tienen gente a su cargo, salvo los empleados regulares. Los directores tienen a su cargo gerentes, los
    gerentes a mandos medios, los mandos medios a líderes de proyecto y éstos a
    empleados regulares.
     */
    @Test
    public void testCalcularSueldoSubordinadosParcial() {
        EmpleadoInterface empleado1 = new EmpleadoRegular("Juan", "Perez");
        EmpleadoInterface empleado2 = new EmpleadoRegular("Maria", "Gomez");
        EmpleadoInterface gerente = new EmpleadoConGenteACargo(3000, List.of(empleado1, empleado2), ar.unrn.tp5.ejercicio1.ROL.GERENTE);

        double sueldoTotal = gerente.calcularSueldoSubordinados();
        assertEquals(7000, sueldoTotal, 0.001);
    }

    @Test
    public void testCalcularSueldoEmpleados() {
        // Empleados regulares
        EmpleadoInterface empleado1 = new EmpleadoRegular("Juan", "Perez");
        EmpleadoInterface empleado2 = new EmpleadoRegular("Maria", "Gomez");

        // Lider de proyecto con empleados regulares
        EmpleadoInterface liderProyecto = new EmpleadoConGenteACargo(3000, List.of(empleado1, empleado2), ar.unrn.tp5.ejercicio1.ROL.LIDER_PROYECTO);

        // Mando medio con lideres de proyecto
        EmpleadoInterface mandoMedio = new EmpleadoConGenteACargo(4000, List.of(liderProyecto), ar.unrn.tp5.ejercicio1.ROL.MANDO_MEDIO);

        // Gerente con mandos medios
        EmpleadoInterface gerente = new EmpleadoConGenteACargo(5000, List.of(mandoMedio), ar.unrn.tp5.ejercicio1.ROL.GERENTE);

        // Director con gerentes
        EmpleadoInterface director = new EmpleadoConGenteACargo(6000, List.of(gerente), ar.unrn.tp5.ejercicio1.ROL.DIRECTOR);

        // Calcular sueldo total
        double sueldoTotal = director.calcularSueldoSubordinados();

        // Verificar: Director 6000 + Gerente 5000 + MandoMedio 4000 + Lider 3000 + 2 empleados 2000 cada = 22000
        assertEquals(22000, sueldoTotal, 0.001);
    }
}
