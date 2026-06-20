package argel.utilizacion;

import argel.framework.Accion;

public class AccionDos implements Accion {
    public AccionDos(){
    }
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando accion dos...");
    }

    @Override
    public String nombreItemMenu() {
        return "Nombre 1+1";
    }

    @Override
    public String descripcionItemMenu() {
        return "Descripcion subjetiva positiva";
    }
}
