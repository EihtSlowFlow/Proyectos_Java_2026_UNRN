package ar.edu.unrn.modelo.Punto2;

public interface Consumible {
    double precio();

    /// El consumible "acepta" a la tarjeta para que ella compute el descuento
    void computarDescuento(Tarjeta tarjeta);
}
