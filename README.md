# Árbol de Expansión Mínima - Prim y Kruskal

## Descripción del proyecto

Este proyecto implementa una aplicación en Java para demostrar el funcionamiento de los Árboles de Expansión Mínima, también conocidos como MST por sus siglas en inglés: *Minimum Spanning Tree*.

La aplicación simula un sistema de conexión entre sucursales ubicadas en diferentes ciudades. Cada ciudad representa un nodo del grafo y cada conexión entre ciudades representa una arista con un costo asociado. El objetivo es encontrar las conexiones necesarias para unir todas las sucursales con el menor costo posible, evitando ciclos.

Para resolver el problema se implementaron dos algoritmos clásicos de teoría de grafos:

* Algoritmo de Prim
* Algoritmo de Kruskal

Además, el proyecto cuenta con una interfaz gráfica desarrollada con Java Swing, donde el usuario puede visualizar el grafo y ejecutar ambos algoritmos mediante botones.

---

## Objetivo general

Implementar una solución en Java que permita encontrar el Árbol de Expansión Mínima de un grafo ponderado, utilizando los algoritmos de Prim y Kruskal.

---

## Objetivos específicos

* Representar un grafo mediante nodos, aristas y pesos.
* Simular una red de conexión entre sucursales.
* Implementar el algoritmo de Prim.
* Implementar el algoritmo de Kruskal.
* Comparar los resultados obtenidos por ambos algoritmos.
* Mostrar los resultados mediante una interfaz gráfica en Java Swing.

---

## Conceptos aplicados

### Grafo

Un grafo es una estructura formada por vértices o nodos y aristas. En este proyecto, las ciudades representan los nodos y las conexiones entre ellas representan las aristas.

### Grafo ponderado

Un grafo ponderado es aquel en el que cada arista tiene un valor o peso. En este caso, el peso representa el costo de conexión entre dos sucursales.

### Árbol de Expansión Mínima

Un Árbol de Expansión Mínima es un subconjunto de aristas que conecta todos los nodos de un grafo, sin formar ciclos y con el menor costo total posible.

---

## Algoritmos implementados

### Algoritmo de Prim

El algoritmo de Prim inicia desde un nodo específico y va expandiendo el árbol seleccionando siempre la arista de menor costo que conecte un nodo visitado con un nodo no visitado.

En este proyecto, Prim inicia desde la ciudad de Quito.

### Algoritmo de Kruskal

El algoritmo de Kruskal ordena todas las aristas del grafo de menor a mayor costo. Luego, selecciona las aristas más económicas siempre que no formen ciclos.

Para evitar ciclos, se utiliza la estructura Union-Find.

---

## Estructura del proyecto

```text
src/
 ├── algoritmo/
 │   ├── Kruskal.java
 │   ├── Prim.java
 │   └── UnionFind.java
 │
 ├── controlador/
 │   └── MSTController.java
 │
 ├── modelo/
 │   ├── Arista.java
 │   ├── Grafo.java
 │   └── ResultadoMST.java
 │
 ├── servicio/
 │   └── GrafoSucursalService.java
 │
 ├── ventana/
 │   ├── Ventana.java
 │   └── Ventana.form
 │
 └── Main.java
```

---

## Descripción de las clases

### `Arista.java`

Representa una conexión entre dos nodos del grafo. Contiene el origen, el destino y el peso o costo de la conexión.

### `Grafo.java`

Representa el grafo completo. Almacena la lista de vértices y la lista de aristas. También permite agregar nuevas conexiones y mostrar el grafo.

### `ResultadoMST.java`

Guarda el resultado generado por los algoritmos. Contiene las aristas seleccionadas y el costo total del Árbol de Expansión Mínima.

### `Prim.java`

Contiene la implementación del algoritmo de Prim. Utiliza una cola de prioridad para seleccionar siempre la arista de menor costo disponible.

### `Kruskal.java`

Contiene la implementación del algoritmo de Kruskal. Ordena las aristas por peso y selecciona aquellas que no generan ciclos.

### `UnionFind.java`

Estructura auxiliar utilizada por Kruskal para verificar si dos nodos ya están conectados y evitar la formación de ciclos.

### `GrafoSucursalService.java`

Crea el grafo de ejemplo con las ciudades y conexiones utilizadas en la aplicación.

### `MSTController.java`

Funciona como intermediario entre la lógica del programa y la interfaz gráfica. Desde esta clase se ejecutan los algoritmos y se obtienen los resultados.

### `Ventana.java`

Clase encargada de la interfaz gráfica. Permite visualizar el grafo y ejecutar los algoritmos mediante botones.

### `Main.java`

Clase principal del programa. Inicia la aplicación y muestra la ventana gráfica.

---

## Grafo utilizado en el ejemplo

Las sucursales utilizadas son:

* Quito
* Guayaquil
* Cuenca
* Manta
* Loja

Las conexiones disponibles son:

```text
Quito - Guayaquil | Costo: 10
Quito - Cuenca    | Costo: 6
Quito - Manta     | Costo: 8
Guayaquil - Manta | Costo: 5
Guayaquil - Loja  | Costo: 12
Cuenca - Loja     | Costo: 4
Cuenca - Manta    | Costo: 7
Manta - Loja      | Costo: 9
```

---

## Funcionalidades de la aplicación

La aplicación permite:

* Mostrar el grafo de sucursales.
* Ejecutar el algoritmo de Prim.
* Ejecutar el algoritmo de Kruskal.
* Visualizar las conexiones seleccionadas.
* Mostrar el costo mínimo total.
* Comparar el resultado obtenido por ambos algoritmos.

---

## Resultado esperado

Tanto Prim como Kruskal deben encontrar un Árbol de Expansión Mínima con el mismo costo total.

Ejemplo de resultado:

```text
Conexiones seleccionadas:
- Cuenca - Loja | Costo: 4
- Guayaquil - Manta | Costo: 5
- Quito - Cuenca | Costo: 6
- Cuenca - Manta | Costo: 7

Costo mínimo total: 22
```

El orden de las conexiones puede variar dependiendo del algoritmo utilizado, pero el costo mínimo total debe ser el mismo.

---

## Requisitos

* Java JDK 8 o superior
* IntelliJ IDEA
* Java Swing

---

## Cómo ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que la estructura de paquetes esté correctamente configurada.
3. Ejecutar la clase `Main.java`.
4. Se abrirá la ventana principal de la aplicación.
5. Presionar el botón correspondiente para ejecutar Prim o Kruskal.
6. Observar el resultado en el área de texto.

---

## Conclusión

Este proyecto demuestra cómo los Árboles de Expansión Mínima permiten resolver problemas de optimización en grafos ponderados. Mediante los algoritmos de Prim y Kruskal es posible seleccionar las conexiones necesarias para unir todos los nodos con el menor costo total posible.

La implementación en Java permite visualizar de forma práctica la diferencia entre ambos algoritmos. Prim construye el árbol desde un nodo inicial, mientras que Kruskal selecciona las aristas más económicas evitando ciclos. Aunque sus estrategias son diferentes, ambos permiten obtener una solución óptima para el problema planteado.
