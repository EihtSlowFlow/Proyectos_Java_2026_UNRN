package argel.main;

import argel.framework.Start;

public class Principal {
    public static void main(String[] args) {
        String PATH = "/config.properties";
        Start nombre = new Start(PATH);
        nombre.init();
    }
}
