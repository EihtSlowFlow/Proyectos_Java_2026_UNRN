package ar.unrn.tp4.ejercicio3.modelo;


// Prestar atención a la "obsesión con los primitivos"
public class Telefono {
    public static final String MENSAJE_FORMATO_INCORRECTO = "El teléfono debe ingresarse: NNNN-NNNNNN";
    public static final String MENSAJE_TELEFONO_INVALIDO = "telefono no puede ser vacio";
    private String numeroTelefonico;

    public Telefono(String telefono) {
        if (existo(telefono) && tengoFormatoCorrecto(telefono)) {
            this.numeroTelefonico = telefono;
        }
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private boolean tengoFormatoCorrecto(String telefono) {
        if (!checkPhone(telefono)) {
            throw new IllegalArgumentException(MENSAJE_FORMATO_INCORRECTO);
        }
        return true;
    }

    private boolean existo(String telefono) {
        if ("".equals(telefono)) {
            throw new IllegalArgumentException(MENSAJE_TELEFONO_INVALIDO);
        }
        return true;
    }


    @Override
    public String toString() {
        return this.numeroTelefonico;
    }


}
