package ar.unrn.tp7.ejercicio2;

import java.io.IOException;
// En realidad es el proxy.
public class ProcesadorDeTexto implements FileAccessInterface {
    private FileAccess fileAccess;
    private Usuario usuario;

    public ProcesadorDeTexto(String ruta, String nombreArchivo, Usuario usuario) {
        this.fileAccess = new FileAccess(ruta, nombreArchivo);
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {
        if (usuario.poseePermiso(Permiso.ADMIN) && fileAccess.comienzaCon("i")) {
            return fileAccess.readFile();
        } else if (usuario.poseePermiso(Permiso.ADMIN) && usuario.poseePermiso(Permiso.INTERMEDIO) && fileAccess.comienzaCon("m")) {
            return fileAccess.readFile();
        }else if(!fileAccess.comienzaCon("i") && !fileAccess.comienzaCon("m")){
            return fileAccess.readFile();
        }else{
        throw new SecurityException("Este Usuario no tiene permisos para leer el archivo.");
    }
    }

}
