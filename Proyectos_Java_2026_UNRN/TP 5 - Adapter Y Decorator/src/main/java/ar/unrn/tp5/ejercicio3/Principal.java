package ar.unrn.tp5.ejercicio3;

import java.io.File;

import java.io.IOException;
/*
Utilice el pattern Decorador para reescribir la funcionalidad de Reporte, de modo tal que le
permita escribir Reportes que exporten sin verificar si el archivo existe (o sea, lo sobreescriba)
y Reportes que no permitan sobrescribir el archivo.
 */

public class Principal {

    public static final String PATH = "/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP 5 - Adapter Y Decorator/src/main/java/ar/unrn/tp5/ejercicio3/reporte1.txt";
    public static void main(String[] args) {
        try {
            Reporte reportador1 = new ReporteSimple("Reporte de ventas");
            reportador1.export(new File(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        Este si se descomenta funciona para un archivo con otro nombre distinto del actual. Deberá ajustarse a la ubicacion relativa del proyecto
        dependiendo de dónde el usuario lo deje.


        Reporte reportador2 = new ReporteSimple("Reporte de normal de la normalidad");
        Reporte report = new ReportSinSobreescritura(reportador2);
        try {
            report.export(new File(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
        Reporte reporteSimple = new ReporteSimple("Reporte reportado");
        Reporte reportador3 = new ReportConSobreescritura(reporteSimple);

        try {
            reportador3.export(new File(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
