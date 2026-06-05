package ar.unrn.strategy.punto2;

public class Principal {
    public static void main(String[] args) {
        Persona personita = new Persona(java.time.LocalDate.of(2000, 1, 1), new FechaCorta());
        System.out.println(personita.fechaNacimiento());
        Persona personita2 = new Persona(java.time.LocalDate.of(2000, 1, 1), new FechaLarga());
        System.out.println(personita2.fechaNacimiento());



    }
}
