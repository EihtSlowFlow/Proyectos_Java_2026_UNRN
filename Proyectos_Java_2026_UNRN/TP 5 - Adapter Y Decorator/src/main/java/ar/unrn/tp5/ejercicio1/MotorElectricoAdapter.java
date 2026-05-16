package ar.unrn.tp5.ejercicio1;

public class MotorElectricoAdapter implements Motor{
    MotorElectrico thisMotor = new MotorElectrico();
    @Override
    public void arrancar() {
        thisMotor.conectarYActivar();
    }

    @Override
    public void acelerar() {
        thisMotor.moverMasRapido();
    }

    @Override
    public void apagar() {
        thisMotor.detenerYDesconectar();
    }
}
