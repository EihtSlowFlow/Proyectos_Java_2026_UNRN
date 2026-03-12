package ar.edu.unrn.modelo.punto2;


public record Consumible(String nombre, double precio, Categoria categoria) {
    public enum Categoria {
        PLATO_PRINCIPAL, BEBIDA
    }

}