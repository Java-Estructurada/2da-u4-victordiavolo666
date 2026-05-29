# 🚀 Examen - Unidad 4: Trazabilidad e Inventario de Berries en Cámaras Frías 🍓🧊

**Objetivo:** 🎯 Dominar la organización avanzada de datos en Java integrando **arreglos unidimensionales (vectores)**, **arreglos multidimensionales (matrices)** y **estructuras de datos heterogéneas (clases/objetos)** para modelar, auditar e inspeccionar inventarios perecederos en tiempo real.

**Contexto:** 🚜 Cadena de frío y logística agroindustrial en el Sur de Jalisco (Ciudad Guzmán).

---

## 📖 Contexto del Problema ❄️

En las plantas agroexportadoras de **Ciudad Guzmán**, mantener la integridad de la cadena de frío es de vida o muerte para las berries (arándanos, frambuesas y zarzamoras). Si un lote de fruta pasa demasiados días almacenado o experimenta fluctuaciones fuera del rango óptimo de temperatura en las cámaras de refrigeración, pierde inmediatamente su certificación de exportación.

Como ingeniero de software a cargo del almacén, debes desarrollar el **Módulo de Trazabilidad e Inventario**. Este sistema debe controlar dos grandes fuentes de información:
1.  **Inventario Global (Matriz 2D):** El conteo físico de palés (pallets) almacenados actualmente en las **3 cámaras frigoríficas** de la planta, donde cada cámara almacena **4 variedades** de berries.
2.  **Registro de Lotes de Exportación (Vector de Estructuras/Objetos):** El historial detallado de los lotes de fruta que están en espera de embarque, analizando su estado de calidad de forma individual.

---

## 📥 Especificaciones del Sistema (Reglas de Negocio) ⚙️

Debes diseñar e implementar las siguientes estructuras de datos y funcionalidades de manera secuencial:

### 1. 🏗️ Estructura del Registro: La Clase `LoteBerry`
Debes construir una clase llamada `LoteBerry` que sirva como molde para representar las propiedades de cada lote de exportación. Debe contener los siguientes campos de datos:
* `String idLote` 🏷️ (Ej: `"LOTE-401"`)
* `String variedad` 🍇 (Ej: `"Arándano"`, `"Frambuesa"`, `"Zarzamora"`)
* `double temperaturaActual` 🌡️ (Temperatura en grados Celsius, ej: `2.3`)
* `int diasAlmacenado` 📅 (Días transcurridos desde su cosecha, ej: `5`)
* `boolean aptoExportacion` 🚢 (Estado de aprobación que inicia como `true` por defecto).

*Nota técnica:* Incluye un constructor para inicializar fácilmente estos datos al instanciar el arreglo de objetos.

### 2. 📋 Auditoría de Lotes (Arreglo Unidimensional de Objetos)
El sistema debe declarar y llenar un arreglo de tipo `LoteBerry[]` de tamaño exacto 4 con datos de prueba. Posteriormente, implementará una subrutina de inspección que recorra este vector y evalúe la aptitud de cada lote según los estándares de inocuidad:
* **Regla de Rechazo:** Un lote deja de ser apto para exportación (`aptoExportacion = false`) si se cumple cualquiera de las siguientes condiciones:
    * La temperatura registrada es menor a $1.0^\circ\text{C}$ o mayor a $4.5^\circ\text{C}$ (Riesgo de congelación o maduración acelerada).
    * Los días de almacenamiento son estrictamente mayores a **7 días** (Pérdida de vida de anaquel).
* El programa debe mostrar el reporte individual de cada lote, destacando el motivo de rechazo en caso de no ser apto.

### 3. 🏢 Análisis del Almacén (Arreglo Bidimensional - Matriz)
La planta cuenta con una matriz numérica de `int[3][4]` que registra la cantidad de palés almacenados.
* **Eje de Filas (3):** Representa las Cámaras Frías (Cámara 1, Cámara 2, Cámara 3).
* **Eje de Columnas (4):** Representa las variedades (0: Arándano, 1: Frambuesa, 2: Zarzamora, 3: Fresa).

Tu sistema debe:
1.  Mostrar el mapa del almacén en un formato tabular limpio.
2.  Calcular y mostrar el **total de palés almacenados** en toda la planta.
3.  Determinar qué cámara frigorífica (fila) está operando con el mayor volumen de fruta almacenada.

---

## ⚠️ Restricciones Técnicas

* **Modularidad en un solo archivo:** Para facilitar la entrega y la evaluación de la Unidad 4, el programa se desarrollará en un único archivo de código llamado `MonitoreoAlmacen.java`.
* **Definición de Clases:** La clase de datos `LoteBerry` debe definirse arriba o abajo del bloque de la clase principal `MonitoreoAlmacen`, pero **fuera de ella** (clases no anidadas).
* **Sin métodos de librerías complejas:** Toda la manipulación, acumulación e iteración de las estructuras debe hacerse utilizando bucles `for` anidados clásicos y manipulación directa de índices.

---

## 📤 Ejemplo de Salida Esperada en Consola ✨

```text
=====================================================
 🚜 LOGÍSTICA DE FRÍO - BERRYCOLD CD. GUZMÁN 🍇❄️
=====================================================

🔍 EJECUTANDO AUDITORÍA EN TIEMPO REAL (Lotes 1D):
-----------------------------------------------------
ID: LOTE-401 | Arándano  | Temp: 2.2°C | Días: 4 | Estado: [✅ APTO EXPORTACIÓN]
ID: LOTE-402 | Frambuesa | Temp: 0.8°C | Días: 5 | Estado: [❌ RECHAZADO: Falla de Temperatura]
ID: LOTE-403 | Zarzamora | Temp: 3.1°C | Días: 9 | Estado: [❌ RECHAZADO: Exceso de Días]
ID: LOTE-404 | Fresa     | Temp: 1.8°C | Días: 3 | Estado: [✅ APTO EXPORTACIÓN]

-----------------------------------------------------
🏢 MAPA DE INVENTARIO EN CÁMARAS FRÍAS (Matriz 2D):
-----------------------------------------------------
            Arándano  Frambuesa  Zarzamora  Fresa
Cámara 1:   12        8          15         20        
Cámara 2:   5         14         10         12        
Cámara 3:   18        9          7          22        

📊 MÉTRICAS FINALES DE INVENTARIO:
+ Volumen total en stock: 137 palés de fruta.
+ Sector más ocupado: Cámara #1 (Total: 55 palés).
=====================================================
Auditoría completada. Alerta enviada al área de embarques.
```
