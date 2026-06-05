package ar.unrn.strategy.punto1;

import java.util.List;

public interface TipoDeEnvio {
    double precio(List<Producto> productos, String destino);
}
