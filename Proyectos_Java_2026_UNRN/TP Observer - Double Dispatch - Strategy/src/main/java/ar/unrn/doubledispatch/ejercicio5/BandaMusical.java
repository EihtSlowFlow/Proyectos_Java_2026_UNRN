package ar.unrn.doubledispatch.ejercicio5;

import java.time.Year;

public class BandaMusical {
    Year anioFormacion;
    Year produccionDePieza;
    public BandaMusical(Year anioFormacion, Year produccionDePieza) {
        this.anioFormacion = anioFormacion;
        this.produccionDePieza = produccionDePieza;
    }

    public int getAnioFormacion() {
        return anioFormacion.getValue();
    }

    public int getProduccionDePieza() {
        return produccionDePieza.getValue();
    }
}
