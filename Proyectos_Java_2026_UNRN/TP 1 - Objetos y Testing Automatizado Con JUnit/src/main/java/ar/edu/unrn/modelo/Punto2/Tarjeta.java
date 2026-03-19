package ar.edu.unrn.modelo.Punto2;

public interface Tarjeta {
    void iniciarProcesamiento();

    void descontarBebida(double precio);

    void descontarPlato(double precio);

    double totalDescuentoAcumulado();
}
