package ar.unrn.doubledispatch.ejercicio5;

public class Prestamo {
   // public static final String DIAS_ADV = "Dias de prestamo no valido";
    // esta clase deberá encargarse de los cálculos, en primera instancia.
    private final Persona prestatario;
    private TipoArticulo tipoArticulo;
    public Prestamo(Persona prestatario, TipoArticulo tipoArticulo) {
        this.prestatario = prestatario;
        this.tipoArticulo = tipoArticulo;
    }
    public int diasDePrestamo() {
        return tipoArticulo.dias();
    }


}

