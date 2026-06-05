package ar.unrn.strategy.punto1;

public class ServicioConConexion implements ServicioWeb {
    String URL = "http://distancia.ar?orgen=capital&destino=xxx";
    @Override
    public double determinarKilometraje() {
        System.out.println("Nada che, te equivocaste de servicio");
        System.out.println("Definitivamente me conecté a " + URL);
        return  0;
    }


}
