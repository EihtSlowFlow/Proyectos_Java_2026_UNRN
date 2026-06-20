package prueba;
import argel.framework.Accion;

public class Accion3 implements Accion{
    public Accion3(){

    }
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando accion 3");
    }
    @Override
    public String nombreItemMenu() {
        return "Item accion 3";
    }
    @Override
    public String descripcionItemMenu() {
        return "Descripcion item 3";
    }
}
