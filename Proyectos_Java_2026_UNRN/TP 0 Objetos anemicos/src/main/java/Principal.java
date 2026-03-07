public class Principal {
    public static void main(String[] args) {
        System.out.println("Tiempo No Anemico:");
        Tiempo_No_Anemico_V2 tiempo1 = new Tiempo_No_Anemico_V2(3, 4, 2020);
        System.out.println(tiempo1.formatoA());
        System.out.println(tiempo1.formatoB());
        System.out.println("\n");
        Tiempo_Anemico tiempo2 = new Tiempo_Anemico(3, 4, 2020);
        FormateadorExterno formateador = new FormateadorExterno();
        System.out.println("Tiempo Anemico:");
        /// Recibe tiempo2 como parametro, pero el formateador modifica el estado interno del objeto Tiempo_Anemico,
        /// lo cual cumple contradice el encapsulamiento(nadie debe conocer el estado interno del objeto)
        /// y por lo tanto el objeto es anemico.

        System.out.println(formateador.FormatoA(tiempo2));
        System.out.println(formateador.FormatoB(tiempo2));
    }
}
