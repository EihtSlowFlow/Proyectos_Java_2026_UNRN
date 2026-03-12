package ar.edu.unrn.modelo.punto2;

public class Restaurante {
    public static void main(String[] args) {
        // Crea un menu con valores predeterminados
        MenuElectronico menu = new MenuElectronico();
        menu.realizarPedido(1); // Milanesa con papas fritas
        menu.realizarPedido(4); // Gaseosa de Cola
        menu.realizarPedido(2); // Pizza con muzzarella
        menu.realizarPedido(5); // Agua Mineral
        menu.finalizarPedido("MASTERCARD", 0.02);
    }
}
