package ar.unrn.tp5.ejercicio4;

public class main {
    public static void main(String[] args) {
        Complemento combo = new ComboBasico();
        Complemento pedido = new DecoradorCarne(new DecoradorQueso(new DecoradorTomate(combo)));
        System.out.println("El precio del pedido es: " + pedido.precio());
        System.out.println("La descripción del pedido es: " + pedido.descripcion());

        System.out.println("-----------------------------");
        Complemento combo2 = new ComboEspecial();
        Complemento pedidoMeGustaMuchoLaCarne = new DecoradorCarne(new DecoradorCarne(new DecoradorCarne(new DecoradorCarne(combo2))));
        System.out.println("El precio del pedido es: " + pedidoMeGustaMuchoLaCarne.precio());
        System.out.println("La descripción del pedido es: " + pedidoMeGustaMuchoLaCarne.descripcion());

    }
}
