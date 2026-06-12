package ar.unrn.tp4.ejercicio3.modelo;

public class InscriptionManager implements InscriptionManagement {
    private final OutExport outExport;

    public InscriptionManager(OutExport outExport) {
        this.outExport = outExport;
    }

    public void inscribirCandidato(Candidato ca) {
        ca.registrarse(outExport);
    }

}
