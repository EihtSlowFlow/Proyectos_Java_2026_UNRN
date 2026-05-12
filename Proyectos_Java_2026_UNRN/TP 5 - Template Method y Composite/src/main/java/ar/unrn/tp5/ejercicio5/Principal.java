package ar.unrn.tp5.ejercicio5;

public class Principal {
    public static void main(String[] args) {
        Comercio comercio = new Comercio(0.10);
        Remera nacional1 = new RemeraNacional(100);
        System.out.println("Remera importada costo: $" + comercio.calcularPrecioFinal(nacional1));

        Comercio comercio2 = new Comercio(0.20);
        Remera importada1 = new RemeraImportada(100);
        System.out.println("Remera importada costo: $"+comercio2.calcularPrecioFinal(importada1));

    }
}
