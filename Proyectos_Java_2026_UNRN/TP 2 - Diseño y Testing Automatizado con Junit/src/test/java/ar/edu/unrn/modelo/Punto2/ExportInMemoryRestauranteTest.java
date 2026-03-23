package ar.edu.unrn.modelo.Punto2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExportInMemoryRestauranteTest {
    Pedido pedido;
    Tarjeta tarjeta;
    MenuElectronico menu;
    FileExportInMemory fileEXP;
    LocalDateTime fechaHoraActual = LocalDateTime.of(2026, 3, 26, 12, 0); // Simulamos que es el 26 de marzo de 2026 a las 12:00

    @BeforeEach
    void setup() {

        menu = new MenuElectronico();
        menu.realizarPedido(1);
        menu.realizarPedido(2);
        menu.realizarPedido(3);

        tarjeta = new Visa();
        fileEXP = new FileExportInMemory();
        pedido = new Pedido(menu.getListaPedido(), tarjeta, fileEXP);

    }

    @Test
    void testExportableEnMemoria() {
        pedido.setFechaActual(fechaHoraActual); // Establecemos la fecha simulada
        pedido.finalizarPedido(2);

        String lineaEsperada = String.format("26/03/2026 12:00:00 || %.2f",
                pedido.calcularTotalFinal(2));

        assertTrue(fileEXP.datos().contains(lineaEsperada),
                "El archivo no contiene el formato exacto pedido por el profesor.");
    }

    @Test
    void testExportacionMasivaCSV() {
        menu.realizarPedido(1);
        Pedido pedidoReal = new Pedido(menu.getListaPedido(), tarjeta, fileEXP);
        pedidoReal.setFechaActual(fechaHoraActual);
        pedidoReal.finalizarPedido(10);

        String contenido = fileEXP.datos();

        // Debug
        System.out.println("DEBUG - Contenido del CSV:\n" + contenido);

        assertTrue(contenido.contains("Pizza"), "Falta la Pizza en: " + contenido);
    }


}
