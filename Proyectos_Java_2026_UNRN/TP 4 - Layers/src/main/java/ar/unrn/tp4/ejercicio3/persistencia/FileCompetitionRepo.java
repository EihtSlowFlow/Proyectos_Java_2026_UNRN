package ar.unrn.tp4.ejercicio3.persistencia;

import ar.unrn.tp4.ejercicio3.modelo.CompetitionManagement;
import ar.unrn.tp4.ejercicio3.modelo.Concurso;

import java.util.ArrayList;
import java.util.List;

public class FileCompetitionRepo implements CompetitionManagement {
    LectorArchivo lector;

    public FileCompetitionRepo(LectorArchivo lector) {
        this.lector = lector;
    }

    @Override
    public List<Concurso> todosLosConcursos() {
        // TODO: Cargar del archivo concursos.txt los concursos abiertos
        /*
        todosLosConcursos(): Recupera del archivo concursos.txt los concursos si su inscripción se encuentra abierta.
        Y los muestra en el Combo.
         */
        List<Concurso> todos = lector.todosLosConcursos();
        List<Concurso> abiertos = new ArrayList<>();
        for (Concurso concurso : todos) {
            if (concurso.estaAbierto()) {
                abiertos.add(concurso);
            }
        }
        return abiertos;
    }
}
