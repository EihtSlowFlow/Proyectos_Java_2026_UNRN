package ar.unrn.tp4.ejercicio2.modelo;

/*
    Esta clase representa al sistema. Basicamente, lo que pide la consigna.
 */

public class SistemaNotificador {
    private final ExportProvider LecturaEmpleados;
    private final MailProvider notificarEmpleado;


    public SistemaNotificador(ExportProvider lecturaEmpleados, MailProvider notificarEmpleado) {
        LecturaEmpleados = lecturaEmpleados;
        this.notificarEmpleado = notificarEmpleado;
    }

    public void enviarNotificacionCumpleanos() {
        var empleados = LecturaEmpleados.obtenerEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado.esMiCumpleanos()) {
                String mensaje = String.format("¡Feliz cumpleaños, %s %s!", empleado.nombre(), empleado.apellido());
                notificarEmpleado.enviarMail(empleado.correoElectronico(), "¡Feliz cumpleaños!", mensaje);
            }
        }
    }


}
