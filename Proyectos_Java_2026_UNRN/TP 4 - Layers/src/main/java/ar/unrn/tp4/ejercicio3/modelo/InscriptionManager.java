package ar.unrn.tp4.ejercicio3.modelo;

public class InscriptionManager implements InscriptionManagement {
    private final OutExport outExport;

    public InscriptionManager(OutExport outExport) {
        this.outExport = outExport;
    }

    public void inscribirCandidato(String nombre, String apellido, String telefono, String email, int idConcurso) {
        Candidato ca = new Candidato(apellido, nombre, telefono, email, idConcurso);
        if (validations(ca)) {
            outExport.saveInscription(ca);
        }
    }


    private boolean validations(Candidato candidato) {
        // Deberían causar una excepción y manejarla en el layout.
        if ("".equals(candidato.nombre())) {
            throw new IllegalArgumentException("nombre no puede ser vacio");
        }
        if ("".equals(candidato.apellido())) {
            throw new IllegalArgumentException("apellido no puede ser vacio");
        }
        if ("".equals(candidato.telefono())) {
            throw new IllegalArgumentException("telefono no puede ser vacio");
        }
        if (!checkEmail(candidato.email())) {
            throw new IllegalArgumentException("email no cumple con el formato (correo@algo.otracosa)");
        }
        if (!checkPhone(candidato.telefono())) {
            throw new IllegalArgumentException("El teléfono debe ingresarse: NNNN-NNNNNN");
        }
        if (candidato.idconcurso() <= 0) {
            throw new IllegalArgumentException("Debes seleccionar un concurso valido");
        }
        return true;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

}
