package ar.edu.unrn.modelo.Punto2;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {
    @Test
    public void testTarjetaVisaCon2PorcientoDePropina() {
        /* 3% DE DESCUENTO SOBRE LAS BEBIDAS */
        // 1. Setup
        Tarjeta visa = new Visa();
        List<Consumible> lista = new ArrayList<>();
        lista.add(new Plato(2000, "Pizza"));
        lista.add(new Bebida(500, "Gaseosa"));
        lista.add(new Plato(1500, "Milanesa"));
        lista.add(new Bebida(300, "Agua"));

        Pedido pedido = new Pedido(lista, () -> visa);

        // 2. Exercise
        double subtotalBruto = 4300.0;
        double descuentoEsperado = 800.0 * 0.03; // 24.0 --> De la VISA
        double subtotalConDescuento = subtotalBruto - descuentoEsperado; // 4276.0 --> Descuento de VISA sobre las bebidas
        double propinaEsperada = subtotalConDescuento * 0.02; // 85.52 --> Propina calculada sobre el subtotal con descuento
        // (no se especificó sobre qué monto se toma la propina, ya que varía según el negocio)

        double valorEsperado = subtotalConDescuento + propinaEsperada;
        double totalAPagar = pedido.calcularTotalFinal(2); // 2% de propina

        // 3. Verify
        // Usamos un delta de 0.01 por si hay redondeos en los decimales
        assertEquals(valorEsperado, totalAPagar, 0.01, "El total final con Visa y 2% de propina es incorrecto");
    }

    @Test
    public void testTarjetaMasterCardCon5PorcientoDePropina() {
        /*2% DE DESCUENTO SOBRE LOS PLATOS PRINCIPALES  */
        // 1. Setup
        Tarjeta masterCard = new MasterCard();
        List<Consumible> lista = new ArrayList<>();
        lista.add(new Plato(2000.32, "Pizza"));
        lista.add(new Bebida(800, "Jugo"));
        lista.add(new Plato(5700.99, "Tira Asado"));
        lista.add(new Plato(9832.03, "Pizza Con Relleno De Queso, Queso en los bordes y Queso sobre el queso"));
        lista.add(new Bebida(300, "Agua"));

        Pedido pedido = new Pedido(lista, () -> masterCard);

        // 2. Exercise
        double subtotalBruto = 2000.32 + 800 + 5700.99 + 9832.03 + 300; /// 17833.34 --> Suma de todos los consumibles sin descuentos
        double descuentoEsperado = (2000.32 + 5700.99 + 9832.03) * 0.02; /// 438.75 --> De la MasterCard sobre los platos (no se aplica descuento a las bebidas)
        double subtotalConDescuento = subtotalBruto - descuentoEsperado; /// 19594.34 --> Con el descuento de MasterCard sobre los platos
        double propinaEsperada = subtotalConDescuento * 0.05; /// 979.72 --> Propina calculada sobre el subtotal con descuento
        /// (no se especificó sobre qué monto se toma la propina, ya que varía según el negocio)

        double valorEsperado = subtotalConDescuento + propinaEsperada;
        double totalAPagar = pedido.calcularTotalFinal(5); // 5% de propina


        // 3. Verify
        // Usamos un delta de 0.01 por si hay redondeos en los decimales
        assertEquals(valorEsperado, totalAPagar, 0.01, "El total final con MasterCard y 5% de propina es incorrecto");
    }

    @Test
    public void testTarjetaComarcaPlus() {
        /*2% DE DESCUENTO SOBRE EL COSTO TOTAL  */
        // 1. Setup
        Tarjeta ComarcaPlus = new Comarca_Plus();
        List<Consumible> lista = new ArrayList<>();
        lista.add(new Plato(12000, "Docena de empanadas"));
        lista.add(new Bebida(2300, "Vino"));
        lista.add(new Plato(15000, "Asado"));
        lista.add(new Bebida(500, "Agua Mineral"));

        Pedido pedido = new Pedido(lista, () -> ComarcaPlus);

        // 2. Exercise
        double subtotalBruto = 29800; /// Suma de todos los consumibles sin descuentos
        double descuentoEsperado = 29800 * 0.02; /// 596.0 --> De la Comarca Plus sobre el total (aplica descuento a todo el pedido)
        double subtotalConDescuento = subtotalBruto - descuentoEsperado; /// 29204.0 --> Con el descuento de Comarca Plus sobre el total
        double propinaEsperada = subtotalConDescuento * 0.05; /// 1460.20 --> Propina calculada sobre el subtotal con descuento
        /// (no se especificó sobre qué monto se toma la propina, ya que varía según el negocio)

        double valorEsperado = subtotalConDescuento + propinaEsperada;
        double totalAPagar = pedido.calcularTotalFinal(5); // 5% de propina


        // 3. Verify
        // Usamos un delta de 0.01 por si hay redondeos en los decimales
        assertEquals(valorEsperado, totalAPagar, 0.01, "El total final con Comarca Plus y 5% de propina es incorrecto");
    }

    @Test
    public void testTarjetaViedmaConDiezPorCientoPropina() {
        /*DESCUENTO DEL 0.0% SOBRE EL TOTAL*/
        // 1. Setup
        Tarjeta viedma = new TarjetaSinDescuento();
        List<Consumible> lista = new ArrayList<>();
        lista.add(new Plato(7000, "Media docena de Empanadas"));
        lista.add(new Bebida(800, "Jugo"));
        lista.add(new Bebida(2000, "Lata de Cerveza 710ML")); // Corregido a Bebida

        Pedido pedido = new Pedido(lista, () -> viedma);

        // 2. Exercise
        // Subtotal Bruto: 7000 + 800 + 2000 = 9800
        // Descuento Viedma: 0.0
        // Subtotal con Descuento: 9800.0
        // Propina (10% sobre 9800.0): 980.0

        double valorEsperado = 9800.0 + 980.0; // 10780.0
        double totalAPagar = pedido.calcularTotalFinal(10); // 10% de propina

        // 3. Verify
        assertEquals(valorEsperado, totalAPagar, 0.01, "El total final con Viedma y 10% de propina es incorrecto");
    }

    @Test
    public void testMenuElectronico() {
        /*CON DESCUENTO DEL 0.0% SOBRE EL TOTAL*/
        // 1. Setup

        Tarjeta viedma = new TarjetaSinDescuento();
        MenuElectronico menu = new MenuElectronico();
        List<Consumible> lista;
        menu.realizarPedido(1); /// Milanesa con papas fritas (1500)
        menu.realizarPedido(4); /// Gaseosa de Cola (500)
        menu.realizarPedido(2); /// Pizza con muzzarella (2000)
        menu.realizarPedido(5); /// Agua Mineral (300)

        lista = menu.getListaPedido();
        Pedido pedido = new Pedido(lista, () -> viedma);


        // 2. Exercise
        double subtotalBruto = 4300; /// Suma de todos los consumibles sin descuentos (1500 + 500 + 2000 + 300)
        double descuentoEsperado = 0.0; /// 0.0 --> De la Viedma sobre el total (aplica descuento a todo el pedido, pero es 0%)
        double subtotalConDescuento = subtotalBruto - descuentoEsperado;
        double propinaEsperada = subtotalConDescuento * 0.05; /// 215.0 --> Propina calculada sobre el subtotal con descuento
        /// (no se especificó sobre qué monto se toma la propina, ya que varía según el negocio)

        double valorEsperado = subtotalConDescuento + propinaEsperada;
        double totalAPagar = pedido.calcularTotalFinal(5); // 5% de propina

        pedido.finalizarPedido(5); // Esto no afecta el cálculo, solo devuelve un resumen de cuenta en formato String

        // 3. Verify
        assertEquals(valorEsperado, totalAPagar, 0.01, "El total final con Viedma y 5% de propina es incorrecto");
    }

    @Test
    public void testMenuElectronicoFueraDeRango() {
        /*CON DESCUENTO DEL 0.0% SOBRE EL TOTAL*/
        // 1. Setup

        Tarjeta viedma = new TarjetaSinDescuento();
        MenuElectronico menu = new MenuElectronico();
        List<Consumible> lista;
        menu.realizarPedido(0); /// Fuera de rango, no se agrega nada
        menu.realizarPedido(6); /// Fuera de rango, no se agrega nada
        lista = menu.getListaPedido();

        // 2. Exercise
        Pedido pedido = new Pedido(lista, () -> viedma);
        pedido.finalizarPedido(5); // Esto no afecta el cálculo, solo devuelve un resumen de cuenta en formato String
        // 3. Verify
        assertEquals(0, lista.size(), "No se deben agregar consumibles fuera de rango");

    }


}
