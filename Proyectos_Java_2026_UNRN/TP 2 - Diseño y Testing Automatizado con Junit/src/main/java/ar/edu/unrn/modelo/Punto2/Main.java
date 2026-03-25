package ar.edu.unrn.modelo.Punto2;

import ar.edu.unrn.persistencia.JdbcExportRestaurante;

import java.time.LocalDateTime;

public class Main {


    static void main() {

        Tarjeta visa = new Visa();
        LocalDateTime fechaAleatoria = LocalDateTime.now();
        // Aquí el usuario elige:
        Export exportador = new JdbcExportRestaurante();
        // O: Export exportador = new FileExportRestaurante("pedidos.txt");


        MenuElectronico menu = new MenuElectronico();
        menu.realizarPedido(1);
        menu.realizarPedido(2);
        // List<Consumible> consumibles, Supplier<Tarjeta> tarjetaSupplier
        Pedido p = new Pedido(menu.getListaPedido(), exportador, () -> new Visa(), () -> fechaAleatoria);

        // El pedido ejecuta el toCSV y el exportador se encarga del resto
        System.out.println(p.finalizarPedido(10));
    }
}
