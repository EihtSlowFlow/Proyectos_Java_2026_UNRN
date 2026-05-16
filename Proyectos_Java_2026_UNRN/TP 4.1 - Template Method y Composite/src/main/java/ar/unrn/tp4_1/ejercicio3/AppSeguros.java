package ar.unrn.tp4_1.ejercicio3;

import java.util.List;

public class AppSeguros {
    List<SeguroInterface> seguros;

    public AppSeguros(List<SeguroInterface> seguros) {
        this.seguros = seguros;
    }

    public void mostrarMain(){
        double resultadofinal = 0;
        for (SeguroInterface seguro : seguros) {
            resultadofinal += seguro.calcularCosto();
        }
        System.out.println("El costo total de los seguros es: " + resultadofinal);
    }
   public double calcularCostosDeSeguros(){
        double resultadofinal = 0;
        for (SeguroInterface seguro : seguros) {
            resultadofinal += seguro.calcularCosto();
        }
        return resultadofinal;
    }


}
