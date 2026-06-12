package ar.unrn.tp4.ejercicio3.modelo;

public interface OutExport {
    // Inscribe a un participante, dependiendo de la implementación lo hará sobre un .txt o sobre la BD
    void saveInscription(String apellido, String nombre, String telefono, String email, int idConcurso);

}
