package ar.unrn.doubledispatch.ejercicio5;

import java.time.Year;

public class Principal {
    public static void main(String[] args) {
        Condicion hechoPelota = new Deteriorado();
        Condicion usado = new Usado();
        Condicion nuevito = new Nuevo();
        Libro fervorDeBuenosAires = new Libro(hechoPelota,500);
        Persona juan = new Persona(12345678, "Juan", "Perez");
        Prestamo pres = new Prestamo(juan, fervorDeBuenosAires);
        System.out.println("Dias de prestamo: " + pres.diasDePrestamo());


        Revista laGranOdiseaDeHomeroSimpson = new Revista(nuevito, Year.of(2010), 400);
        Persona joao = new Persona(12345678, "Gomero", "G.Simpson");
        Prestamo prestamo = new Prestamo(joao, laGranOdiseaDeHomeroSimpson);
        System.out.println("Dias de prestamo JOAO: " + prestamo.diasDePrestamo());


        Revista fixinThings = new Revista(usado, Year.of(2010), 200);
        Persona nombreCreativo1 = new Persona(12345678, "Electric", "Boogaloo");
        Prestamo prestamo2 = new Prestamo(nombreCreativo1, fixinThings);
        System.out.println("Dias de prestamo Electric: " + prestamo2.diasDePrestamo());

        Disco boogiesTwoThousand = new Disco(usado, new BandaMusical(Year.of(2000), Year.of(2005)));
        Persona nombreCreativo2 = new Persona(12345678, "Disco", "Stu");
        Prestamo prestamo3 = new Prestamo(nombreCreativo2, boogiesTwoThousand);
        System.out.println("Dias de prestamo Disco: " + prestamo3.diasDePrestamo());


        Disco TheLowEndTheory = new Disco(hechoPelota, new BandaMusical(Year.of(1970), Year.of(2000)));
        Persona nombreCreativo3 = new Persona(12345678, "Disco", "Stu");
        Prestamo prestamo4 = new Prestamo(nombreCreativo3, TheLowEndTheory);
        System.out.println("Dias de prestamo Disco: " + prestamo4.diasDePrestamo());

        try {
            Disco discoDeteriLoViejon = new Disco(hechoPelota, new BandaMusical(Year.of(1970), Year.of(1975)));
            Persona nombreCreativo4 = new Persona(12345678, "Jamiro", "Quai");
            Prestamo prestamo5 = new Prestamo(nombreCreativo4, discoDeteriLoViejon);
            System.out.println("Dias de prestamo Disco Viejo: " + prestamo5.diasDePrestamo());
        } catch (UnsupportedOperationException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }







    }
}
