package ar.unrn.tp4.ejercicio3.modelo;

public class InscriptionManager implements InscriptionManagement {
    private final OutExport outExport;

    public InscriptionManager(OutExport outExport) {
        this.outExport = outExport;
    }

    public void inscribirCandidato(Candidato ca) {
        ca.registrarse(outExport);
    }

/*
    private boolean validations(Candidato candidato) {
        // Deberían causar una excepción y manejarla en el layout.
        /// Sacar estas validaciones al candidato.
        /// luego revisar cómo sacar las excepciones y sigan funcionales.
        /// CAMBIAR NOMBRES.!


        return true;
    }

 */

}
