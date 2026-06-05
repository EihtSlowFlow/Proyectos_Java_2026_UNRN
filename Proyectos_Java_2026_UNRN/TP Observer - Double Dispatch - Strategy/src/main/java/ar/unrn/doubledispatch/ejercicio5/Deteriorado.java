package ar.unrn.doubledispatch.ejercicio5;

public class Deteriorado implements Condicion{


    public static final String CONDICION_ADV = "El disco es muy antiguo, no se puede prestar";

    @Override
    public int calcularDias(Disco disco) {
        int diasBase = 5;
        if (disco.bandaSonora().getProduccionDePieza() < 1980) {
            throw new UnsupportedOperationException(CONDICION_ADV);
        }else if(disco.bandaSonora().getProduccionDePieza() >= 1980) {
            return diasBase - 1;
        }
        return diasBase;
    }

    @Override
    public int calcularDias(Libro libro) {
        float dias = (float) libro.cantidadDePaginas / 100;
        return Math.round(dias);
    }

    @Override
    public int calcularDias(Revista revista) {
        if(revista.anioPublicacionRevista() > 10){
            return 3;
        }
        return 1;
    }
}
