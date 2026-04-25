package ar.unrn.tp4.ejercicio3.modelo;

// Prestar atención a la "obsesión con los primitivos"
public class eMail {
    public static final String MENSAJE_FORMATO_INCORRECTO = "email no cumple con el formato (correo@algo.otracosa)";
    String email;

    public eMail(String email) {
        if (validarFormato(email)) {
            this.email = email;
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean validarFormato(String email) {
        if (!checkEmail(email)) {
            throw new IllegalArgumentException(MENSAJE_FORMATO_INCORRECTO);
        }
        return true;
    }

    @Override
    public String toString() {
        return this.email;
    }
}
