package ar.unrn.tp5.ejercicio4;

public class ComboBasico implements Complemento {
    private double precio;
    private String descripcion;

    public ComboBasico() {
        this.precio = 5000;
        this.descripcion = "Cantidad mediana de cosas";
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
