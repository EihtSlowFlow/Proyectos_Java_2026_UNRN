package ar.unrn.tp5.ejercicio4;

public class PrincipalConBuilder {
    public static void main(String[] args) {
        menuBuilder prueba = new menuBuilder(new ComboBasico());
        prueba.DecoradorQueso().DecoradorCarne().DecoradorPapas().DecoradorTomate().DecoradorCarne().DecoradorPapas();
        Complemento pedido = prueba.build();
        System.out.println("El precio del pedido es: " + pedido.precio());
        System.out.println("La descripción del pedido es: " + pedido.descripcion());
    }
}
