package ar.unrn.tp5.ejercicio5;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        LocalDate inicioRelativo = LocalDate.of(2024, 6, 15);
        Concurso concursoUno = new Concurso(LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 30), "Concurso x", () -> inicioRelativo);
        Inscribible salida = new PorWhatsapp(new PorCorreoEnMemoria(concursoUno));
        salida.inscribir(new Participante("Juan", "Perez", 30, 12345678, "corretrucho@gmail.com"));
    }
}
