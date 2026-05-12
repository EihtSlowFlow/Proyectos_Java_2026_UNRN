package ar.unrn.tp5.ejercicio4;

public class Principal {
    public static void main(String[] args) {
        LogTransaction log = new LogTransaction() {
            @Override
            public void log(String className) {
                    System.out.println("Log: " + className);
            }
        };



        Calculador calculadorJubilado = new CalculadorJubilado(log, 6);
        Calculador calculadorNoJubilado = new CalculadorNoJubilado(log, 6);

        double precioProducto = 100.0;

        double precioFinalJubilado = calculadorJubilado.calcularPrecio(precioProducto);
        double precioFinalNoJubilado = calculadorNoJubilado.calcularPrecio(precioProducto);

        System.out.println("Precio final para jubilado: " + precioFinalJubilado);
        System.out.println("Precio final para no jubilado: " + precioFinalNoJubilado);
    }
}
