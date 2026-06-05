package ar.unrn.strategy.punto1.tests;
import ar.unrn.strategy.punto1.*;

public class FakeServicioWeb implements ServicioWeb{
    @Override
    public double determinarKilometraje() {
        return 500;
    }
}
