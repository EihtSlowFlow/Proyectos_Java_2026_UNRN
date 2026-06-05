package ar.unrn.strategy.punto2;

import java.time.LocalDate;

public class FechaCorta implements FormatoFechaNac {

    @Override
    public String formatearFecha(LocalDate P) {
        return P.getDayOfMonth() + "-" +P.getMonthValue() + "-" + P.getYear();
    }
}
