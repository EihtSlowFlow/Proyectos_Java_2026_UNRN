package ar.unrn.tp4.ejercicio3.persistencia;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
public class LogAspect {
    String PATH = "/home/ramiro/Documentos/UNRN_Orientacion_a_objetos_II/Proyectos_Java_2026_UNRN/TP AOP - LayRefac/src/main/resources/LOGs.txt";
    @Before("@annotation(ar.unrn.tp4.ejercicio3.persistencia.Log)")
    public void antesDeListar(JoinPoint joinPoint) {
            String metodo = joinPoint.getSignature().getName();
            Object[] argumentos = joinPoint.getArgs();
        if (argumentos == null || argumentos.length == 0 || argumentos[0] == null) {
            Object[] argumentosPorDefecto = new Object[]{ "sin parametro" };
            escribirSobreArchivo(metodo, argumentosPorDefecto);

        } else {
            escribirSobreArchivo(metodo, argumentos);
        }

    }

    private void escribirSobreArchivo(String metodo, Object[] argumentos) {
        StringBuilder valores = new StringBuilder();
        for (int i = 0; i < argumentos.length; i++) {
            valores.append(argumentos[i]);
            if (i < argumentos.length - 1) {
                valores.append("|");
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fechaFormateada = LocalDateTime.now().format(formatter);

        String lineaFinal = String.format("%s, %s, %s",
                metodo, valores.toString(), fechaFormateada);

        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH, true))) {
            writer.println(lineaFinal);
        } catch (IOException e) {
            throw new RuntimeException("Error guardando en: " + PATH, e);
        }

    }
}
