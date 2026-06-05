package ar.unrn.doubledispatch.ejercicio5;

import java.time.Year;

public class Revista implements TipoArticulo {
    public static final String REVISTA_ADV = "La revista no tiene banda sonora";
    public static final String NRO_PAGINAS_ADV = "El número de páginas no puede ser negativo ni cero";
    private Condicion condicion;
    private Year anioPublicacion;
    private int paginasRevista;
    public Revista(Condicion condicion, Year anioPublicacion, int paginas) {
        this.condicion = condicion;
        if(paginas <= 0) {
            throw new IllegalArgumentException(NRO_PAGINAS_ADV);
        }
        this.paginasRevista = paginas;
    }

    protected int anioPublicacionRevista(){
        return anioPublicacion.getValue();
    }

    @Override
    public int dias() {
        return condicion.calcularDias(this);
    }

    @Override
    public int hojas() {
        return paginasRevista;
    }

    @Override
    public BandaMusical bandaSonora() {
        throw new RuntimeException(REVISTA_ADV);
    }
}
