package ar.unrn.tp5.ejercicio4;

public class ComboFamiliar implements Complemento {
    private double precio;
    private String descripcion;

    public ComboFamiliar() {
        this.precio = 10000;
        this.descripcion = "Cantidad grande de cosas";
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
