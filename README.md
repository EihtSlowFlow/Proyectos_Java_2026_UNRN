¡Excelente idea! Un buen **README** es la cara de tu código, especialmente si Molinari o algún compañero revisa tu repositorio en GitHub. Al estar en la rama `Punto_2_Refactor_CSV`, este archivo debe explicar **por qué** decidiste cambiar la estrategia de exportación.

Aquí tenés una propuesta de `README.md` estructurada, clara y con un toque de "pro":

---

# 🍽️ Restaurante OO2 - Refactor CSV (Punto 2)

Este módulo forma parte del **TP 2 de Orientación a Objetos II**. Esta rama específica (`Punto_2_Refactor_CSV`) implementa una mejora en la arquitectura de persistencia, pasando de un registro transaccional línea por línea a una **exportación estructurada en formato CSV**.

## 🚀 ¿Qué hay de nuevo en este Refactor?

En lugar de escribir en el archivo cada vez que ocurre un evento, el sistema ahora construye un **reporte completo del pedido** al finalizar la transacción.

### Mejoras Técnicas:
* **Uso de `StringBuilder`:** Optimizamos la memoria al construir el bloque de texto completo antes de enviarlo al sistema de archivos, evitando la creación excesiva de objetos `String`.
* **Encabezados CSV:** El archivo generado ahora incluye una fila de encabezado (`Fecha, Item, Precio...`), facilitando su apertura en herramientas como Excel o Google Sheets.
* **Delegación de Identidad:** Aplicamos `@Override` al método `toString()` en las clases `Plato` y `Bebida` para que los objetos sepan representarse a sí mismos en el reporte.

---

## 🏗️ Principios de Diseño Aplicados

Para este refactor, nos basamos en los pilares fundamentales de la POO:

1.  **Tell, Don't Ask (TDA):** El `Pedido` no "le pregunta" los datos al `Plato`. En su lugar, le pide al objeto que se comporte (a través de `toString` o `comoLineaCSV`) para obtener su representación.
2.  **Double Dispatch:** Mantenemos la lógica de descuentos basada en el tipo de consumible, delegando la decisión a la jerarquía de `Plato` y `Bebida`.
3.  **Inyección de Dependencias:** El sistema de exportación (`Export`) se inyecta al crear el pedido, permitiendo testear la lógica en memoria sin tocar el disco rígido.



---

## 📊 Formato de Salida (CSV)

El archivo generado en `/home/ramiro/tp2-punto2-pedidosExportados.txt` sigue esta estructura:

```csv
Fecha, Item, Precio, Total Final con Propina
23/03/2026 19:15:00, Pizza con relleno de queso, 2000.00, 2310.00
23/03/2026 19:15:00, Gaseosa de Cola, 500.00, 2310.00
```

---

## 🧪 Estrategia de Testing

Se implementaron dos niveles de validación para asegurar que el refactor no rompa la funcionalidad:

* **Tests Unitarios (In-Memory):** Usamos un `FileExportInMemory` para validar que el `StringBuilder` genere el formato CSV correcto, las comas y los saltos de línea.
* **Tests de Integración (Real File):** Verificamos que el `FileExportRestaurante` realmente cree el archivo físico en el sistema operativo (Kubuntu) y persista los datos.

> [!IMPORTANT]
> **Nota para el revisor:** Antes de correr los tests de integración, el sistema limpia el archivo de salida para evitar falsos positivos por datos residuales de ejecuciones anteriores.

---

## 🛠️ Cómo correr los tests en IntelliJ

1.  Hacer clic derecho sobre la carpeta `src/test/java/ar/edu/unrn/modelo/Punto2`.
2.  Seleccionar **"Run 'Tests in Punto2' with Coverage"**.
3.  Verificar que la clase `Pedido` y su método `toCSV` tengan una cobertura del 100%.

---
