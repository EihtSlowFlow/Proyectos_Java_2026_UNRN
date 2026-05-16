package ar.unrn.tp5.ejercicio1;

public class Principal {
    public static void main(String[] args) {
        Motor motorComun = new MotorComun();
        Motor motorEconomico = new MotorEconomico();
        Motor motorElectrico = new MotorElectricoAdapter();

        System.out.println("Motor Comun:");
        motorComun.arrancar();
        motorComun.acelerar();
        motorComun.apagar();

        System.out.println("\nMotor Economico:");
        motorEconomico.arrancar();
        motorEconomico.acelerar();
        motorEconomico.apagar();

        System.out.println("\nMotor Electrico:");
        motorElectrico.arrancar();
        motorElectrico.acelerar();
        motorElectrico.apagar();
    }
}
