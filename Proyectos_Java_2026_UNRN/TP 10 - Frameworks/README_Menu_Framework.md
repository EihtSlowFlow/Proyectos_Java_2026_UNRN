# TP 10 - Frameworks: Menu Selector

Breve documentación de uso del mini-framework de menú.

Archivos relevantes:
- `src/main/java/argel/framework/Start.java` - Fachada para inicializar el framework.
- `src/main/java/argel/framework/LectorConfiguracion.java` - Lee el archivo de propiedades que contiene la lista de acciones.
- `src/main/java/argel/framework/Accion.java` - Interfaz que deben implementar las acciones.
- `src/main/java/argel/framework/Accionador.java` - Crea instancias por Reflection a partir de nombres de clase.
- `src/main/java/argel/framework/MenuFramework.java` - Muestra el menú y ejecuta las acciones.

Uso rápido:
1. Crear un archivo de propiedades con la clave `Acciones` que contenga una lista separada por `;` de clases completas (incluyendo paquete) que implementen `Accion`.
   Ejemplo (`menu.properties`):

```
Acciones=mis.paquete.MiAccion1;mis.paquete.MiAccion2
```

2. Llamar a la fachada `Start` con la ruta del recurso (p. ej. `/menu.properties`):

```
new argel.framework.Start("/menu.properties").init();
```

Notas y recomendaciones:
- El framework usa Reflection para crear las acciones: las clases deben tener un constructor público sin argumentos y implementar `Accion`.
- Las excepciones del framework se encapsulan en `ActionException` (extiende `RuntimeException`).



