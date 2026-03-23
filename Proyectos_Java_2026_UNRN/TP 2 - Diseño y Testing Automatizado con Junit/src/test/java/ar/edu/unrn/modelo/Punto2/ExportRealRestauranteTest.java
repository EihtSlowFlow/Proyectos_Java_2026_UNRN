package ar.edu.unrn.modelo.Punto2;

import com.sun.glass.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExportRealRestauranteTest {
    FileExportRestaurante fileExport;
    Pedido pedido123;
    Tarjeta tarjetaGenerica;
    MenuElectronico menu;
    Path filePath = Path.of("/home/ramiro/tp2-punto2-pedidosExportados.txt");

    LocalDateTime fechaHoraActual = LocalDateTime.of(2026, 3, 26, 12, 0); // Simulamos que es el 26 de marzo de 2026 a las 12:00


    @BeforeEach
    void setup() {
        tarjetaGenerica = new MasterCard();
        fileExport = new FileExportRestaurante(filePath.toString());
        menu = new MenuElectronico();
        menu.realizarPedido(1);
        menu.realizarPedido(2);
        menu.realizarPedido(3);

        pedido123 = new Pedido(menu.getListaPedido(), new Visa(), fileExport);
        pedido123.setFechaActual(fechaHoraActual);


    }

    @Test
    void testValidadCorrectitudDeExportacion() {
        Path filePath = Path.of("/home/ramiro/tp2-punto2-pedidosExportados.txt");
        pedido123.finalizarPedido(2);

        try {
            String contenidoArchivo = Files.readString(filePath);
            String lineaEsperada = String.format("26/03/2026 12:00:00 || %.2f",
                    pedido123.calcularTotalFinal(2));

            Assertions.assertTrue(contenidoArchivo.contains(lineaEsperada),
                    "El archivo no contiene el formato exacto pedido por el profesor.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
