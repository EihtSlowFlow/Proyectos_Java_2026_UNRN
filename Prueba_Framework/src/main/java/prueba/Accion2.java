package prueba;
import argel.framework.Accion;

public class Accion2 implements Accion{
    public Accion2(){

    }

    @Override
    public void ejecutar() {
        System.out.println("Accion2");
    }
    @Override
    public String nombreItemMenu() {
        return "Item 2";
    }
    @Override
    public String descripcionItemMenu() {
        return "Descripcion item 2";
    }
}
