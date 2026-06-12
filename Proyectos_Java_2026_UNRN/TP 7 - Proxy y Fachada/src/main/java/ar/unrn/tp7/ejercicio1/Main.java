package ar.unrn.tp7.ejercicio1;

public class Main {
    public static void main() {
        PersonaDao dao = new PersonaDao();
        Persona p = dao.personaPorId(1);

        System.out.println(p.nombre());
/*
        for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
        }

 */
    }
}