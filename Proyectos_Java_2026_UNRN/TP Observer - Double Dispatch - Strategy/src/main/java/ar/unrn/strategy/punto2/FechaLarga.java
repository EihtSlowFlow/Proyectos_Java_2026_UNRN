package ar.unrn.strategy.punto2;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FechaLarga implements FormatoFechaNac {
    @Override
    public String formatearFecha(LocalDate P) {
        String mesTexto = P.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "AR"));
        return P.getDayOfMonth() + " de " + mesTexto + " de " + P.getYear();
    }

}
