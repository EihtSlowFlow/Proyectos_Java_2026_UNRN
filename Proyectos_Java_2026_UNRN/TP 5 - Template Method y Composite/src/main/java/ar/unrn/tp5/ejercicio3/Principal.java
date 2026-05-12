package ar.unrn.tp5.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        SeguroInterface auto = new Seguro(TipoSeguro.AUTOMOVIL, 1000.0);
        SeguroInterface hogar = new Seguro(TipoSeguro.HOGAR, 500.0);
        SeguroInterface vida = new Seguro(TipoSeguro.VIDA_Y_MEDICOS, 300.0);


        PaqueteSeguros paquete1 = new PaqueteSeguros(new ArrayList<>());
        paquete1.agregarSeguro(auto);
        paquete1.agregarSeguro(hogar);
        paquete1.agregarSeguro(vida);

        PaqueteSeguros paqueteGranEmpresa = new PaqueteSeguros(new ArrayList<>());
        paqueteGranEmpresa.agregarSeguro(auto);
        paqueteGranEmpresa.agregarSeguro(paquete1);

        List<SeguroInterface> todosLosSeguros = new ArrayList<>();
        todosLosSeguros.add(paqueteGranEmpresa);

        todosLosSeguros.add(new Seguro(TipoSeguro.AUTOMOVIL, 1200.0));

        AppSeguros app = new AppSeguros(todosLosSeguros);

        app.mostrarMain();
    }
}
