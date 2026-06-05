package ar.unrn.strategy.punto3;



class Producto {
    //public TipoProducto tipo;
    private final CalculadoraPrecioPorTipo calcular;
    public double precio;

    public Producto(CalculadoraPrecioPorTipo calcular, double precio) {
        this.calcular = calcular;
        this.precio = precio;
    }

    public double precioFinal() {
        /*
        double impuestos = 0;
        double descuentos = 0;
        boolean envioGratis = false;
         */
        var envioGratis = calcular.determinarEnvioGratis(this);
        var impuestos = calcular.determinarImpuesto(this);
        var descuentos = calcular.determinarDescuento(this);

        double total = precio * (1 + impuestos) * (1 - descuentos);
        if (envioGratis) {
            total -= 10;
        }

        // Para quitar los decimales excesivos desde acá y no tener que formatear por cada sysout que haga
        return Math.round(total * 100.0) / 100.0;
    }
}