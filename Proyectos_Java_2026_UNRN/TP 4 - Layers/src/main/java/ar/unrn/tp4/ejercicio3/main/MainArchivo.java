package ar.unrn.tp4.ejercicio3.main;

import ar.unrn.tp4.ejercicio3.modelo.CompetitionManagement;
import ar.unrn.tp4.ejercicio3.modelo.InscriptionManager;
import ar.unrn.tp4.ejercicio3.modelo.OutExport;
import ar.unrn.tp4.ejercicio3.persistencia.EscritorArchivo;
import ar.unrn.tp4.ejercicio3.persistencia.FileCompetitionRepo;
import ar.unrn.tp4.ejercicio3.persistencia.LectorArchivo;
import ar.unrn.tp4.ejercicio3.vista.Layout;

public class MainArchivo {
    public static void main(String[] args) {
        OutExport exportador = new EscritorArchivo("/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP 4 - Layers/src/main/resources/Inscriptos.txt");
        LectorArchivo lector = new LectorArchivo("/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP 4 - Layers/src/main/resources/Concursos.txt");
        CompetitionManagement file = new FileCompetitionRepo(lector);
        InscriptionManager manager = new InscriptionManager(exportador);
        new Layout(file, manager);


    }


}
