package controlador;

import algoritmo.Kruskal;
import algoritmo.Prim;
import modelo.Grafo;
import modelo.ResultadoMST;
import servicio.GrafoSucursalService;

public class MSTController {

    private Grafo grafo;
    private GrafoSucursalService grafoSucursalService;

    public MSTController() {
        this.grafoSucursalService = new GrafoSucursalService();
        this.grafo = grafoSucursalService.crearGrafoDeSucursales();
    }

    public String mostrarGrafo() {
        return grafo.mostrarGrafo();
    }

    public String ejecutarPrim() {
        try {
            Prim prim = new Prim();
            ResultadoMST resultado = prim.ejecutar(grafo, "Quito");
            return resultado.mostrarResultado();
        } catch (Exception e) {
            return "Error al ejecutar Prim: " + e.getMessage();
        }
    }

    public String ejecutarKruskal() {
        try {
            Kruskal kruskal = new Kruskal();
            ResultadoMST resultado = kruskal.ejecutar(grafo);
            return resultado.mostrarResultado();
        } catch (Exception e) {
            return "Error al ejecutar Kruskal: " + e.getMessage();
        }
    }

    public String compararAlgoritmos() {
        Prim prim = new Prim();
        Kruskal kruskal = new Kruskal();

        ResultadoMST resultadoPrim = prim.ejecutar(grafo, "Quito");
        ResultadoMST resultadoKruskal = kruskal.ejecutar(grafo);

        StringBuilder sb = new StringBuilder();

        sb.append("COMPARACIÓN ENTRE PRIM Y KRUSKAL\n");
        sb.append("=================================\n\n");

        sb.append("Costo total obtenido con Prim: ")
                .append(resultadoPrim.getCostoTotal())
                .append("\n");

        sb.append("Costo total obtenido con Kruskal: ")
                .append(resultadoKruskal.getCostoTotal())
                .append("\n\n");

        if (resultadoPrim.getCostoTotal() == resultadoKruskal.getCostoTotal()) {
            sb.append("Conclusión técnica:\n");
            sb.append("Ambos algoritmos encontraron un Árbol de Expansión Mínima con el mismo costo total.\n");
            sb.append("Aunque Prim y Kruskal siguen estrategias diferentes, los dos permiten obtener una solución óptima para conectar todas las sucursales con el menor costo posible.");
        } else {
            sb.append("Conclusión técnica:\n");
            sb.append("Los algoritmos generaron costos distintos. Esto puede indicar que el grafo no está conectado correctamente o que existe un error en la implementación.");
        }

        return sb.toString();
    }

    public String obtenerConclusiones() {
        StringBuilder sb = new StringBuilder();

        sb.append("CONCLUSIONES\n");
        sb.append("=================================\n\n");

        sb.append("1. Un Árbol de Expansión Mínima permite conectar todos los vértices de un grafo usando el menor costo posible.\n\n");

        sb.append("2. En el ejemplo desarrollado, las sucursales representan los vértices y las conexiones entre ciudades representan las aristas ponderadas.\n\n");

        sb.append("3. El algoritmo de Prim construye el MST creciendo desde un vértice inicial y seleccionando la conexión más económica hacia un nuevo nodo.\n\n");

        sb.append("4. El algoritmo de Kruskal construye el MST ordenando las aristas por peso y agregándolas siempre que no formen ciclos.\n\n");

        sb.append("5. Ambos algoritmos pueden llegar al mismo costo mínimo, pero utilizan estrategias diferentes para resolver el problema.\n\n");

        sb.append("6. Este tipo de implementación puede aplicarse en problemas reales como redes eléctricas, telecomunicaciones, carreteras, cableado estructurado o conexión entre sucursales empresariales.");

        return sb.toString();
    }

    public Grafo getGrafo() {
        return grafo;
    }
}