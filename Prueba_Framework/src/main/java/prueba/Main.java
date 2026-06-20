package prueba;
// En caso de error, verificar que el modulo utilizado es prueba-framework-local. Y no proyectos-objetos-2

import argel.framework.Start;

public class Main {
	public static void main(String[] args) {
		Start iniciar = new Start("/config.properties");
		iniciar.init();


	}
}
