package ar.unrn.doubledispatch.ejercicio5;

public class Usado implements Condicion{
    @Override
    public int calcularDias(Disco disco) {
        if(disco.bandaSonora().getAnioFormacion() < 1980){
            return 3;
        }else{
            return 5;
        }
    }

    @Override
    public int calcularDias(Libro libro) {
        float dias = (float) libro.cantidadDePaginas / 100;
        return Math.round(dias);
    }

    @Override
    public int calcularDias(Revista revista) {
        if(revista.hojas() < 100){
            return 2;
        }else if(revista.hojas() > 300 &&  revista.hojas() < 2000){
            return 3;
        }
        return 5;
    }
}
