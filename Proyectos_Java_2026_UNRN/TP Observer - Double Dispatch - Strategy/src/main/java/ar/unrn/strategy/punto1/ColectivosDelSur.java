package ar.unrn.strategy.punto1;
import java.util.List;
public class ColectivosDelSur implements TipoDeEnvio {

    public static final int MONTO_FIJO_CF = 1000;
    public static final int MONTO_FIJO_GBS = 1000;
    public static final int MONTO_FIJO_OTRO_D = 3000;

    @Override
    public double precio(List<Producto> productos, String destino) {
        double montoFijo;
        if(destino.trim().equalsIgnoreCase("Capital Federal")){
            montoFijo = MONTO_FIJO_CF;
        } else if (destino.trim().equalsIgnoreCase("Gran Buenos Aires")) {
            montoFijo = MONTO_FIJO_GBS;
        }else{
            montoFijo = MONTO_FIJO_OTRO_D;
        }
        double pesoDelPedido = productos.stream().mapToDouble(Producto::Peso).sum();
        double precioDelPedido = productos.stream().mapToDouble(Producto::Precio).sum() + montoFijo;
        if (pesoDelPedido > 5 && pesoDelPedido < 30) {
            return precioDelPedido + 500.00;
        }else if(pesoDelPedido > 30) {
            return precioDelPedido + 2000.00;
        }
        return Math.round(precioDelPedido) + 50;
    }
}
