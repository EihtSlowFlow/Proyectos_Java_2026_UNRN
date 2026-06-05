package ar.unrn.doubledispatch.ejercicio5;


public class Libro implements TipoArticulo {
    Condicion condicion;
    int cantidadDePaginas;
    public Libro(Condicion condicion, int cantidadDePaginas) {
        this.condicion = condicion;
        this.cantidadDePaginas = cantidadDePaginas;
    }

    @Override
    public int dias() {
        return condicion.calcularDias(this);
    }

    @Override
    public int hojas() {
        return cantidadDePaginas;
    }

    @Override
    public BandaMusical bandaSonora() {
        throw new UnsupportedOperationException("El libro no tiene banda sonora");
    }
}
