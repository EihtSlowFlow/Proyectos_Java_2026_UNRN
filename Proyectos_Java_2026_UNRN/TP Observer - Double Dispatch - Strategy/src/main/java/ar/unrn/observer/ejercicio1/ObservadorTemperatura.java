package ar.unrn.observer.ejercicio1;

public class ObservadorTemperatura implements Observer{
    @Override
    public void actualizarTemperatura(String temperatura) {
        StringBuffer asd = limpiarTemperatura(temperatura);
        double temperaturaCelsius = Double.parseDouble(asd.toString());
        if(temperaturaCelsius < 12){
            System.out.println("Hace frio, se encenderá la caldera");
        }else if(temperaturaCelsius > 17){
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }

    private static StringBuffer limpiarTemperatura(String temperatura) {
        StringBuffer asd = new StringBuffer();
        asd.append(temperatura);
        for (int i = 0; i < asd.length(); i++) {
            if (asd.charAt(i) == ':') {
                asd.delete(0, i + 1);
                asd.delete(asd.length() - 3, asd.length());
                i = 1000;
            }
        }
        return asd;
    }
}
