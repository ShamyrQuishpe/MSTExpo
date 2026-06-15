package algoritmo;

import modelo.Arista;
import modelo.Grafo;
import modelo.ResultadoMST;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    public ResultadoMST ejecutar(Grafo grafo, String verticeInicial) {
        ResultadoMST resultado = new ResultadoMST("Prim");

        if (grafo.getVertices().isEmpty()) {
            return resultado;
        }

        if (!grafo.getVertices().contains(verticeInicial)) {
            throw new IllegalArgumentException("El vértice inicial no existe en el grafo.");
        }

        Set<String> visitados = new HashSet<>();
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>();

        visitados.add(verticeInicial);
        agregarAristasDisponibles(grafo, verticeInicial, visitados, colaPrioridad);

        while (!colaPrioridad.isEmpty() && visitados.size() < grafo.cantidadVertices()) {
            Arista aristaActual = colaPrioridad.poll();

            String origen = aristaActual.getOrigen();
            String destino = aristaActual.getDestino();

            String nuevoVertice = obtenerVerticeNoVisitado(origen, destino, visitados);

            if (nuevoVertice != null) {
                resultado.agregarArista(aristaActual);
                visitados.add(nuevoVertice);
                agregarAristasDisponibles(grafo, nuevoVertice, visitados, colaPrioridad);
            }
        }

        return resultado;
    }

    private String obtenerVerticeNoVisitado(String origen, String destino, Set<String> visitados) {
        if (visitados.contains(origen) && !visitados.contains(destino)) {
            return destino;
        }

        if (visitados.contains(destino) && !visitados.contains(origen)) {
            return origen;
        }

        return null;
    }

    private void agregarAristasDisponibles(
            Grafo grafo,
            String verticeActual,
            Set<String> visitados,
            PriorityQueue<Arista> colaPrioridad
    ) {
        for (Arista arista : grafo.getAristas()) {
            boolean conectaConVerticeActual =
                    arista.getOrigen().equals(verticeActual)
                            || arista.getDestino().equals(verticeActual);

            boolean tieneVerticeNoVisitado =
                    !visitados.contains(arista.getOrigen())
                            || !visitados.contains(arista.getDestino());

            if (conectaConVerticeActual && tieneVerticeNoVisitado) {
                colaPrioridad.add(arista);
            }
        }
    }
}