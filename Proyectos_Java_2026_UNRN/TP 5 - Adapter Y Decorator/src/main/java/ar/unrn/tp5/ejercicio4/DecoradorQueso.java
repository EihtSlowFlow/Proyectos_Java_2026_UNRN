package ar.unrn.tp5.ejercicio4;

public class DecoradorQueso implements Complemento{
    Complemento complemento;
    public DecoradorQueso(Complemento complemento) {
        this.complemento = complemento;
    }
    @Override
    public double precio() {
        return complemento.precio() + 10;
    }

    @Override
    public String descripcion() {
        return complemento.descripcion() + " , queso añadido";
    }
}
