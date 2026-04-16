package ar.unrn.tp4.ejercicio1.dominio;

public record Participante(String nombre, String telefono, String region) {

    public Participante {
        validar(nombre, telefono, region);
    }

    private void validar(String nombre, String telefono, String region) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }

        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un telefono");
        }

        if (!telefono.matches("\\d{4}-\\d{6}")) {
            throw new IllegalArgumentException(
                    "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN"
            );
        }

        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new IllegalArgumentException(
                    "Region desconocida. Las conocidas son: China, US, Europa"
            );
        }
    }
}