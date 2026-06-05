package ar.unrn.strategy.punto1;

public class CorreoArgentino implements TipoDeEnvio {
    public static final int MONTO_FIJO_CF = 500;
    public static final int MONTO_FIJO_OTRO_D = 800;
    public static final double PRECIO_ASOC_PROD = 5.0;
    private final ServicioWeb servicio;
    public CorreoArgentino(ServicioWeb servicio) {
        this.servicio = servicio;
    }



    @Override
    public double precio(java.util.List<Producto> productos, String destino) {
        double precioDelPedido = productos.stream().mapToDouble(Producto::Precio).sum();
        double costoPorUbicacion = 0;
        if (destino.trim().equalsIgnoreCase("Capital Federal")) {
            costoPorUbicacion += MONTO_FIJO_CF;
        } else {
            costoPorUbicacion += MONTO_FIJO_OTRO_D;
        }
        precioDelPedido += (servicio.determinarKilometraje() * PRECIO_ASOC_PROD) + costoPorUbicacion;
        return Math.round(precioDelPedido) ;
    }
}
