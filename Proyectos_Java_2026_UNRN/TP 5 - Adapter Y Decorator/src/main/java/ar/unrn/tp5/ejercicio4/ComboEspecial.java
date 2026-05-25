package ar.unrn.tp5.ejercicio4;

public class ComboEspecial implements Complemento {
    private double precio;
    private String descripcion;

    public ComboEspecial() {
        this.precio = 15000;
        this.descripcion = "Cantidad enorme de cosas";
    }

    @Override
    public double precio() {
        return precio;
    }

    @Override
    public String descripcion() {
        return descripcion;
    }
}
