
import ar.unrn.tp5.ejercicio1.Director;
import ar.unrn.tp5.ejercicio1.EmpleadoInterface;
import ar.unrn.tp5.ejercicio1.EmpleadoRegular;
import ar.unrn.tp5.ejercicio1.Gerente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestEmpresa {
    @Test
    public void testCalculoSueldo() {
        EmpleadoInterface empleado1 = new EmpleadoRegular("Juan", "Perez");
        EmpleadoInterface empleado2 = new EmpleadoRegular("Maria", "Gomez");
        EmpleadoInterface gerente1 = new Gerente(List.of(empleado1, empleado2), "Carlos", "Lopez");
        EmpleadoInterface director = new Director(List.of(gerente1), "Ana", "Garcia");
        double sueldoEsperado=  99999 + 70000 + 2000 + 2000;

        double sueldoTotal = director.calcularSueldoSubordinados();
        assertEquals(sueldoEsperado, sueldoTotal, 0.001);
    }
    @Test
    public void testSueldoEmpleadoRegular() {
        EmpleadoInterface empleado = new EmpleadoRegular("Juan", "Perez");
        assertEquals(2000.0, empleado.calcularSueldoSubordinados(), 0.001);
    }
}
