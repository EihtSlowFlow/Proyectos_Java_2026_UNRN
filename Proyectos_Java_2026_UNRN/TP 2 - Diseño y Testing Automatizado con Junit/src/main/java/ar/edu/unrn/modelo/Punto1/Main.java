package ar.edu.unrn.modelo.Punto1;

import ar.edu.unrn.infraestructura.EmailService;
import ar.edu.unrn.persistencia.JdbcExportConcurso;


import java.time.LocalDate;

public class Main {
    static void main() {
        EmailService emailService = new EmailService();
        // Definimos las credenciales que vimos en la pestaña Database
        LocalDate fec_inscripcion = LocalDate.now();


        // Aquí el usuario elige:
        Export exportador = new JdbcExportConcurso();
        // Export exportador = new FileExportConcurso("pedidos.txt");

        Concurso concurso = new Concurso(fec_inscripcion, fec_inscripcion.plusDays(5), "Art Renewal Center (ARC) Salon Competition (EE.UU.)", exportador);
        Participante participante1 = new Participante("Juan", "Pérez", 30, 12345678, "JuanElMasZarpado@outlook.com");
        Participante participante2 = new Participante("María", "Gómez", 25, 87654321, "Maria20001@gmail.com");
        Participante participante3 = new Participante("Pedro", "López", 28, 11223344, "PedroPicaPapas@hotmail.com");

        concurso.inscribirParticipante(participante1);
        //  concurso.inscribirParticipante(participante2);
        //concurso.inscribirParticipante(participante3);

        exportador.exportar(concurso.toCSV());


    }
}
