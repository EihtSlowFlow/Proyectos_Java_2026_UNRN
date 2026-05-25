package ar.unrn.tp5.ejercicio4;

import java.awt.*;

public class menuBuilder {
    Complemento componente;
    public menuBuilder(Complemento comp) {
        this.componente = comp;
    }
    public menuBuilder DecoradorCarne() {
        this.componente = new DecoradorCarne(componente);
        return this;
    }
    public menuBuilder DecoradorQueso() {
        this.componente = new DecoradorQueso(componente);
        return this;
    }
    public menuBuilder DecoradorPapas() {
        this.componente = new DecoradorPapas(componente);
        return this;
    }
    public menuBuilder DecoradorTomate(){
        this.componente = new DecoradorTomate(componente);
        return this;
    }
    public Complemento build() {
        return this.componente;
    }


}
