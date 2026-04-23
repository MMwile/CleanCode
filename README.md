# Clean Code Lab - Ingenieria de Software

Proyecto base en Java para practicar conceptos de clean code, testing y trabajo colaborativo con Git.

## Objetivo de la practica

Cada alumno debe crear su propia branch, implementar mejoras y resolver ejercicios sin romper el comportamiento funcional del sistema.

Escenario principal de negocio para el laboratorio:
- HN (Honduras) con tax de 15%.

## Requisitos

- Java 21
- Maven 3.9+
- Git

## Como ejecutar

1. Ejecutar pruebas:

   mvn test

2. Ejecutar la app:

   mvn exec:java

## Flujo de trabajo para alumnos

1. Clonar el repositorio.
2. Crear una branch personal con este formato:

   feature/nombre-apellido-clean-code

3. Resolver los ejercicios.
4. Hacer commits pequenos y descriptivos.
5. Subir su branch al remoto.
6. Crear Pull Request hacia main.

## Ejercicios propuestos

### Ejercicio 1: Refactor de calculo de envio

Archivo objetivo:
- src/main/java/edu/isi/cleancode/service/OrderService.java

Problema:
- El metodo calculateShipping tiene logica condicional que puede mejorar en legibilidad y extensibilidad.

Meta:
- Aplicar refactor para reducir condicionales complejos.
- Mantener el comportamiento actual (pruebas deben seguir pasando).

### Ejercicio 2: Mejorar validaciones y mensajes de error

Archivo objetivo:
- src/main/java/edu/isi/cleancode/validation/OrderValidator.java

Problema:
- Solo retorna true/false. No explica por que falla una orden.

Meta:
- Crear una estrategia para reportar errores de validacion (por ejemplo lista de mensajes o resultado enriquecido).
- Adaptar pruebas o agregar nuevas.

### Ejercicio 3: Introducir pruebas adicionales

Archivo objetivo:
- src/test/java/edu/isi/cleancode/service/OrderServiceTest.java

Meta:
- Cubrir casos frontera (montos exactos, pais no contemplado, prioridad internacional).
- Aumentar la confianza del comportamiento.

### Ejercicio 4: Aplicar principios SOLID

Meta:
- Identificar una responsabilidad que pueda separarse en otra clase.
- Justificar el cambio en el Pull Request.

## Retos extra

### Reto Bug Hunter

Regla:
- Antes de corregir, cada alumno debe identificar y documentar 2 bugs potenciales.
- Minimo 1 bug funcional y 1 bug de diseno.

Entrega esperada:
- Crear en el Pull Request una seccion llamada "Bug Hunter" con:
- Descripcion breve del bug.
- Como reproducirlo.
- Riesgo que genera.
- Solucion aplicada.

### No Rompas Nada

Regla:
- No se permite cambiar logica de negocio sin escribir primero una prueba que falle.

Flujo minimo obligatorio:
- Red: crear prueba que falle.
- Green: implementar el cambio minimo para que pase.
- Refactor: mejorar codigo manteniendo pruebas en verde.

Evidencia:
- En el Pull Request indicar que prueba fallo primero y que cambio la hizo pasar.

### Paises Sorpresa (MX, AR, CO)

Objetivo:
- Agregar nuevas reglas de impuestos y/o envio para MX, AR y CO.
- Mantener compatibilidad con reglas existentes (HN, PE, CL y default).

Reglas de calidad:
- No romper casos actuales.
- Agregar pruebas nuevas para cada pais incorporado.
- Documentar brevemente las reglas elegidas en el Pull Request.

### Code Smells Challenge

Objetivo:
- Identificar y corregir code smells en el proyecto.

Lista sugerida de smells a eliminar:
- Metodo largo.
- Condicionales anidadas.
- Nombres ambiguos.
- Logica duplicada.

Entrega esperada:
- Incluir en el Pull Request una seccion "Antes y despues" indicando que smell se encontro y como se corrigio.

## Criterios de evaluacion sugeridos

- Codigo legible y nombres claros.
- Bajo acoplamiento y buena cohesion.
- Cobertura de pruebas en los cambios.
- Commits claros.
- Pull Request con explicacion tecnica.


