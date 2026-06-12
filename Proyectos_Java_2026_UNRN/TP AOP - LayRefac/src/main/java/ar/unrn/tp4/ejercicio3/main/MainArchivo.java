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
        // Recordatorio! --> Hay que cambiar manualmente las fechas dentro del .txt a unas actuales o actualmente en progreso
        // porque sino es muy probable que el concurso no esté disponible y no muestre nada el desplegable
        String PathA = "/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP AOP - LayRefac/src/main/resources/Inscriptos.txt";
        String PathB = "/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP AOP - LayRefac/src/main/resources/Concursos.txt";

        OutExport exportador = new EscritorArchivo(PathA);
        LectorArchivo lector = new LectorArchivo(PathB);
        CompetitionManagement file = new FileCompetitionRepo(lector);
        InscriptionManager manager = new InscriptionManager(exportador);
        new Layout(file, manager);


    }


}
