package ar.unrn.tp4.ejercicio3.modelo;

import java.util.List;

public interface CompetitionManagement {
    // Lista todos los concursos, dependiendo de la implementación leerá un .txt o accederá a la BD
    List<Concurso> todosLosConcursos();
}
