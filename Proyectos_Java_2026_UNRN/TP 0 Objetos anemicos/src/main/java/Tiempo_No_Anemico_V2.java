import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Tiempo_No_Anemico_V2 {
    /// El único estado real y necesario del objeto.
    /// Usamos Calendar internamente, pero nadie afuera lo sabe.
    private final Calendar fechaInterna;

    public Tiempo_No_Anemico_V2(int dia, int mes, int anio) {
        this.fechaInterna = Calendar.getInstance();
        // Recordar la corrección del mes (-1)
        this.fechaInterna.set(anio, mes - 1, dia);
    }

    public String formatoA() {
        // Las herramientas son variables locales, no atributos de la clase
        Locale locFec = new Locale("es", "ES");
        DateFormat formatoFull = DateFormat.getDateInstance(DateFormat.FULL, locFec);
        return formatoFull.format(fechaInterna.getTime());
    }

    public String formatoB() {
        // La herramienta nace y muere en este método
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        return sdf.format(fechaInterna.getTime());
    }
}