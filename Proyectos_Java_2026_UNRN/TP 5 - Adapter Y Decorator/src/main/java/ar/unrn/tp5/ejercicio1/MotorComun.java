package ar.unrn.tp5.ejercicio1;

public class MotorComun implements Motor{
    @Override
    public void arrancar() {
        System.out.println("Arrancó el motor comun");
    }

    @Override
    public void acelerar() {
        System.out.println("Aceleró el motor comun");
    }

    @Override
    public void apagar() {
        System.out.println("Apagó el motor comun");
    }
}
