package ar.edu.unrn.modelo.Punto2;

import ar.edu.unrn.persistencia.JdbcExportRestaurante;

public class Main {
    static void main() {

        // Aquí el usuario elige:
        Export exportador = new JdbcExportRestaurante();
        // O: Export exportador = new FileExportRestaurante("pedidos.txt");

        MenuElectronico menu = new MenuElectronico();
        menu.realizarPedido(1);
        menu.realizarPedido(2);

        Pedido pedido = new Pedido(menu.getListaPedido(), new Visa(), exportador);

        // El pedido ejecuta el toCSV y el exportador se encarga del resto
        System.out.println(pedido.finalizarPedido(10));
    }
}
