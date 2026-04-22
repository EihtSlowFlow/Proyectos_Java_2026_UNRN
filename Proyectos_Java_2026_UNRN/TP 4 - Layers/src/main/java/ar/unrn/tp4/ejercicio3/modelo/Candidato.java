package ar.unrn.tp4.ejercicio3.modelo;

public record Candidato(String apellido, String nombre, String telefono, String email, int idconcurso) {
    @Override
    public String toString() {
        return apellido + ", " + nombre + ", " + telefono + ", " + email + ", " + idconcurso;
    }
}
