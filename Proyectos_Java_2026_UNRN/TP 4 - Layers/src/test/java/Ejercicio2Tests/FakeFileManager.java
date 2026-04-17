package Ejercicio2Tests;

import ar.unrn.tp4.ejercicio2.modelo.Empleado;
import ar.unrn.tp4.ejercicio2.modelo.ExportProvider;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class FakeFileManager implements ExportProvider {


    // private final String rutaArchivo;
    private final List<Empleado> empleados;

    public FakeFileManager(List<Empleado> empleadosSimulados) {
        /// this.rutaArchivo = rutaArchivo;
        this.empleados = empleadosSimulados;
    }

    /*
            public List<Empleado> crearLista() {
                return List.of(
                        new Empleado("Perez", "Juan", fecNacimiento, "Juanceto09@gmail.com"),
                        new Empleado("Gomez", "Maria", fecNacimiento.plusDays(5), "M-A-R@gmail.com"),
                        // Solo se envian dos mails a Carlos y a Ana, porque como está implementado se supone que uno debe cargar al archivo de texto con
                        // los empleados y dependiendo del dia de hoy es o no es su cumpleaños.
                        new Empleado("Lopez", "Carlos", LocalDate.now(), "LopezLopez@gmail.com"),
                        new Empleado("Garcia", "Ana", LocalDate.now(), "123AnaGarcai123@gmail.com"));
            }


     */

    @Override
    public List<Empleado> obtenerEmpleados() {
        return this.empleados;
    }
}
