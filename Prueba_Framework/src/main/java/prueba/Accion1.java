package prueba;

import argel.framework.Accion;
public class Accion1 implements Accion {
    public Accion1(){

    }
@Override
    public void ejecutar() {
    System.out.println("Ejecutando accion 1");
    }@Override
    public String nombreItemMenu() {
        return "Nombre item 1";
    }@Override
    public String descripcionItemMenu() {
        return "Descripcion item 1";
    }


}
