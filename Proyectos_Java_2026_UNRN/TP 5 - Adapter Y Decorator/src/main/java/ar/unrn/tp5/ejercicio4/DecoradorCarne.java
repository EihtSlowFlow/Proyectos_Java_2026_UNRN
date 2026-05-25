package ar.unrn.tp5.ejercicio4;

public class DecoradorCarne implements Complemento{
    Complemento complemento;
    public DecoradorCarne(Complemento complemento) {
        this.complemento = complemento;
    }
    @Override
    public double precio() {
        return complemento.precio() + 20;
    }

    @Override
    public String descripcion() {
        return complemento.descripcion() + " ,carne añadida";
    }
}
