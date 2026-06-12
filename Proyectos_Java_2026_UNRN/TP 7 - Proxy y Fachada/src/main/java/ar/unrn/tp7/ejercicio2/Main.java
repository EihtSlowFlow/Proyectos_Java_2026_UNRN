package ar.unrn.tp7.ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String PATH = "/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP 7 - Proxy y Fachada/src/main/java/ar/unrn/tp7/ejercicio2/";
        Cliente cliente1 = new Cliente(PATH, "importante.txt", new Usuario("Juan", List.of(Permiso.BASICO)));
        cliente1.leerArchivo();
    }
}
