package ar.unrn.tp4.ejercicio2.modelo;

import java.time.LocalDate;

public record Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String correoElectronico) {

    public boolean esMiCumpleanos() {
        return fechaNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth() &&
                fechaNacimiento.getMonth() == LocalDate.now().getMonth();
    }}
