package ar.unrn.tp5.ejercicio4;

public class DecoradorPapas implements Complemento{
    Complemento complemento;
    public DecoradorPapas(Complemento complemento) {
        this.complemento = complemento;
    }
    @Override
    public double precio() {
        return complemento.precio() + 5000;
    }

    @Override
    public String descripcion() {
        return complemento.descripcion() + " ,papas añadidas";
    }
}
