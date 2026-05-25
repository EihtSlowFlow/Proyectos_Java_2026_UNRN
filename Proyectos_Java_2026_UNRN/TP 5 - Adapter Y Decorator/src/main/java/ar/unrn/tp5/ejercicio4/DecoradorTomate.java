package ar.unrn.tp5.ejercicio4;

public class DecoradorTomate implements Complemento{
    Complemento complemento;
    public DecoradorTomate(Complemento complemento) {
        this.complemento = complemento;
    }

    @Override
    public double precio() {
        return this.complemento.precio() + 15;
    }

    @Override
    public String descripcion() {
        return this.complemento.descripcion() + " , tomate añadido";
    }
}
