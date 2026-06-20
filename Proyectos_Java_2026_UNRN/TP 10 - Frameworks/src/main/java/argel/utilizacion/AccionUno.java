package argel.utilizacion;

import argel.framework.Accion;

public class AccionUno implements Accion {
    public AccionUno(){}
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando accion 1...");
    }

    @Override
    public String nombreItemMenu() {
        return "Nombre 'x' + 1";
    }

    @Override
    public String descripcionItemMenu() {
        return "Una intrigante descripcion";
    }
}
