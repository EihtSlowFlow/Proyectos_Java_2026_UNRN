package ar.unrn.tp5.ejercicio3;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class testAppSeguros {

    @Test
    public void testSegurosPaqueteParcial() {
        // 1. Creamos los 3 seguros básicos (Hojas)
        Seguro s1 = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 100);
        Seguro s2 = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 100);
        Seguro s3 = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 100);


        List<SeguroInterface> itemsPaquete = new ArrayList<>();
        itemsPaquete.add(s1);
        itemsPaquete.add(s2);
        itemsPaquete.add(s3);
        PaqueteSeguros paquete = new PaqueteSeguros(itemsPaquete);

        List<SeguroInterface> itemsApp = new ArrayList<>();
        itemsApp.add(s1);
        itemsApp.add(s2);
        itemsApp.add(s3);
        itemsApp.add(paquete);

        AppSeguros aseguradora = new AppSeguros(itemsApp);


        assertEquals(555.0, aseguradora.calcularCostosDeSeguros(), 0.001);
    }

    @Test
    public void testSeguros() {

        Seguro s1 = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 100);
        Seguro s2 = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 100);
        Seguro s3 = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 100);

        List<SeguroInterface> itemsInternos = new ArrayList<>();
        itemsInternos.add(s1);
        itemsInternos.add(s2);
        itemsInternos.add(s3);
        PaqueteSeguros paqueteInterno = new PaqueteSeguros(itemsInternos);

        List<SeguroInterface> itemsPrincipales = new ArrayList<>();
        itemsPrincipales.add(s1);
        itemsPrincipales.add(s2);
        itemsPrincipales.add(s3);
        itemsPrincipales.add(paqueteInterno);
        PaqueteSeguros paquetePrincipal = new PaqueteSeguros(itemsPrincipales);

        List<SeguroInterface> itemsApp = new ArrayList<>();
        itemsApp.add(s1);
        itemsApp.add(s2);
        itemsApp.add(s3);
        itemsApp.add(paquetePrincipal);

        AppSeguros app = new AppSeguros(itemsApp);

        double resultadoEsperado = 688.5;
        assertEquals(resultadoEsperado, app.calcularCostosDeSeguros(), 0.001);
    }
}