package ar.edu.unrn.modelo.Punto2;

public interface Consumible {
    double precio();

    double precioSiEsBebida(); // Las Bebidas devuelven precio(), los Platos devuelven 0.0

    double precioSiEsPlato();  // Los Platos devuelven precio(), las Bebidas devuelven 0.0
}
