package ar.unrn.tp4.ejercicio3.modelo;

public class Candidato {
    public static final String MENSAJE_NOMBRE_VACIO = "nombre no puede ser vacio";
    public static final String MENSAJE_APELLIDO_VACIO = "apellido no puede ser vacio";
    private String apellido;
    private String nombre;
    private final Telefono telefono;
    private final eMail eMail;
    private final Concurso concursoAsociado;

    public Candidato(String apellido, String nombre, Telefono telefono, eMail mail, Concurso concurso) {
        if (tengoApellido(apellido)) {
            this.apellido = apellido;
        }
        if (tengoNombre(nombre)) {
            this.nombre = nombre;
        }
        this.telefono = telefono;
        this.eMail = mail;
        this.concursoAsociado = concurso;
    }

    private boolean tengoNombre(String nombre) {
        if ("".equals(nombre)) {
            throw new IllegalArgumentException(MENSAJE_NOMBRE_VACIO);
        }
        return true;
    }

    private boolean tengoApellido(String apellido) {
        if ("".equals(apellido)) {
            throw new IllegalArgumentException(MENSAJE_APELLIDO_VACIO);
        }
        return true;
    }

    public void registrarse(OutExport exportador) {
        exportador.saveInscription(this.apellido, this.nombre, this.telefono.toString(), this.eMail.toString(), this.concursoAsociado.Idconcurso());
    }

    @Override
    public String toString() {
        return this.apellido + ", " + nombre + ", " + telefono.toString() + ", " + eMail.toString() + ", " + concursoAsociado.toString();
    }
}
