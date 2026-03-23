package ar.edu.unrn.modelo.Punto2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExportRealRestauranteTest {
    FileExportRestaurante fileExportReal;
    Pedido pedido123;
    MenuElectronico menu;

    @BeforeEach
    void setup() throws IOException {
        // despeje de ruta
        String rutaStr = "/home/ramiro/tp2-punto2-pedidosExportados.txt";
        Path path = Path.of(rutaStr);

        // Limpiamos el archivo antes de cada test (si existe)
        new FileWriter(rutaStr, false).close();

        fileExportReal = new FileExportRestaurante(rutaStr);
        menu = new MenuElectronico();

        // Cargamos platos
        menu.realizarPedido(1); // Pizza
        menu.realizarPedido(2); // Milanesa

        // Inyectamos el exportador REAL
        pedido123 = new Pedido(menu.getListaPedido(), new Visa(), fileExportReal);
        pedido123.setFechaActual(LocalDateTime.of(2026, 3, 26, 12, 0));
    }

    @Test
    void testExportacionRealCSV() throws IOException {
        /// Simulamos la finalización del pedido con un descuento del 10%
        pedido123.finalizarPedido(10);
        /// Leemos el contenido del archivo generado
        Path path = Path.of("/home/ramiro/tp2-punto2-pedidosExportados.txt");
        String contenido = Files.readString(path);
        /// Realizamos las aserciones para verificar el formato y contenido del CSV
        assertTrue(contenido.contains("Fecha,Item,Precio"),
                "El archivo real no tiene el encabezado CSV.");
        /// Verificamos que el nombre del plato esté presente en el archivo
        assertTrue(contenido.contains("Pizza con relleno de queso"),
                "El archivo real no guardó el nombre del plato correctamente.");
        ///  Verificamos que el precio del plato esté presente en el archivo
        String totalEsperado = String.format("%.2f", pedido123.calcularTotalFinal(10));
        assertTrue(contenido.contains(totalEsperado),
                "El monto final en el archivo no coincide con el calculado.");
    }


}
