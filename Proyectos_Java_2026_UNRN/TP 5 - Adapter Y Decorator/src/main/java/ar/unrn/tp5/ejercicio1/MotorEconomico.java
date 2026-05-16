package ar.unrn.tp5.ejercicio1;

public class MotorEconomico implements Motor{
    @Override
    public void arrancar() {
        System.out.println("Arrancó el motor economico");
    }
    @Override
    public void acelerar() {
        System.out.println("Aceleró el motor economico");
    }

    @Override
    public void apagar() {
        System.out.println("Apagó el motor economico");
    }
}
