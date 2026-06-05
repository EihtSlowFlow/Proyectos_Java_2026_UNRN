package ar.unrn.doubledispatch.ejercicio5;


public class Disco implements TipoArticulo {
    public static final String DISCO_ADV = "Un disco no tiene hojas.";
    Condicion condicion;
    BandaMusical bandaSonora;
    public Disco(Condicion condicion, BandaMusical bandaSonora) {
        this.condicion = condicion;
        this.bandaSonora = bandaSonora;
    }


    @Override
    public int dias() {
        return condicion.calcularDias(this);
    }

    @Override
    public int hojas() {
        throw new UnsupportedOperationException(DISCO_ADV);
    }

    @Override
    public BandaMusical bandaSonora() {
        return this.bandaSonora;
    }
}
