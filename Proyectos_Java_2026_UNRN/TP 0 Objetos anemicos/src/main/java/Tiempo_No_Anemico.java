import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Locale;

public class Tiempo_No_Anemico {
    private final Calendar fechaHoy = Calendar.getInstance();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    private final Locale locFec = new Locale("es", "ES");
    private final DateFormat FormatoB;

    public Tiempo_No_Anemico(int dia, int mes, int anio) {

        fechaHoy.set(anio, mes - 1, dia);
        sdf.setCalendar(fechaHoy);
        FormatoB = DateFormat.getDateInstance(DateFormat.FULL, locFec);
    }

    public String formatoA() {
        /// Mismo error que en el formatoB, estaba usando el formato de fecha del sistema,
        /// y no el que se le asigno a la variable FormatoB, por eso no me daba el resultado esperado.
        return (FormatoB.format(fechaHoy.getTime()));
    }

    public String formatoB() {
        /// Antes tenia un error, estaba usando el formato de fecha
        /// del sistema, y no el que se le asigno a la variable sdf, por eso no me daba el resultado esperado.
        return (sdf.format(fechaHoy.getTime()));
    }
}
