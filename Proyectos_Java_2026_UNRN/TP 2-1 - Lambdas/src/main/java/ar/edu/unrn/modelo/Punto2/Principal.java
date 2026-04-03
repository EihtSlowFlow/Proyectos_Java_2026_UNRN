package ar.edu.unrn.modelo.Punto2;

public class Principal {
    public static void main(String[] args) {
        AprendiendoLambdas app = new AprendiendoLambdas();
        app.unMetodo(C -> (C.length() % 2 == 0));
        app.unMetodo(C -> (C.startsWith("a")));


    }
}
