import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormateadorExterno {
    Calendar fecha = Calendar.getInstance();

    public String FormatoB(Tiempo_Anemico tiempo) {
        /// El formateador modifica el estado interno del objeto Tiempo_Anemico
        ///  lo cual contradice el encapsulamiento(nadie debe conocer el estado interno del objeto) y por lo tanto
        ///  el objeto es anemico.
        fecha.set(tiempo.getAnio(), tiempo.getMes() - 1, tiempo.getDia());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        sdf.setCalendar(fecha);
        return sdf.format(fecha.getTime());
    }

    public String FormatoA(Tiempo_Anemico tiempo) {
        Locale locFec = new Locale("es", "ES");
        DateFormat formatoFull = DateFormat.getDateInstance(DateFormat.FULL, locFec);
        /// El formateador modifica el estado interno del objeto Tiempo_Anemico.
        /// Antes tenia un error, estaba usando el formato de fecha del sistema, y no el que se le asigno a la variable formatoFull, por eso no me daba el resultado esperado.
        fecha.set(tiempo.getAnio(), tiempo.getMes() - 1, tiempo.getDia());
        return formatoFull.format(fecha.getTime());
    }
}
