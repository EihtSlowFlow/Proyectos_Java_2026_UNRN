package ar.edu.unrn.modelo.Punto2;

import java.util.ArrayList;

public class MenuElectronico {
    /// private final int cantBebidas = 0;
    /// private final int cantPlatos = 0;
    private final ArrayList<Consumible> platos = new ArrayList<>();
    private final ArrayList<Consumible> pedido = new ArrayList<>();

    public MenuElectronico() {
        /// Constructor con valores predeterminados
        platos.add(new Plato(2000, "Pizza con relleno de queso con queso en los bordes y queso en el queso"));
        platos.add(new Plato(1500, "Milanesa con papas fritas"));
        platos.add(new Plato(3000, "Bife de chorizo con ensalada"));
        platos.add(new Bebida(500, "Gaseosa de Cola"));
        platos.add(new Bebida(300, "Agua Mineral"));
    }

    public void realizarPedido(int numeroPlato) {
        // La condición es que el número esté DENTRO del rango
        if (numeroPlato >= 1 && numeroPlato <= platos.size()) {
            Consumible seleccionado = platos.get(numeroPlato - 1);
            pedido.add(seleccionado);
        } else {
            System.err.println("Número de plato inválido.");
        }
    }

    public ArrayList<Consumible> getListaPedido() {
        return pedido;
    }
}
