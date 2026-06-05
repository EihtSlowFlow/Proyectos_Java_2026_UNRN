package ar.unrn.strategy.punto1;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        ServicioWeb servicio = new ServicioEnMemoria();
        TipoDeEnvio tipo = new CorreoArgentino(servicio);
        List<Producto> misProductos = new ArrayList<>();
        Producto producto1 = new Producto(2, 500, "keso", 1000);
        Producto producto2 = new Producto(1, 250, "mas keso", 500);
        misProductos.add(producto1);
        misProductos.add(producto2);
        double precioTotal = tipo.precio(misProductos, "Capital Federal");
        System.out.println("El precio total del envío por colectivos del sur es: " + precioTotal);


        TipoDeEnvio tipoCorreo = new ColectivosDelSur();
        List<Producto> misProductos1 = new ArrayList<>();
        Producto producto3 = new Producto(2, 500, "alguien dijo queso", 1000);
        Producto producto4 = new Producto(1, 250, "fui yo, si", 500);
        misProductos1.add(producto3);
        misProductos1.add(producto4);
        double precioTotalFinal = tipoCorreo.precio(misProductos1, "Capital Federal");
        System.out.println("El precio total del envío por correo argentino es: " + precioTotalFinal);

    }
}
