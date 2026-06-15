package algoritmo;

import modelo.Arista;
import modelo.Grafo;
import modelo.ResultadoMST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public ResultadoMST ejecutar(Grafo grafo) {
        ResultadoMST resultado = new ResultadoMST("Kruskal");

        List<Arista> aristasOrdenadas = new ArrayList<>(grafo.getAristas());
        Collections.sort(aristasOrdenadas);

        UnionFind unionFind = new UnionFind();

        for (String vertice : grafo.getVertices()) {
            unionFind.crearConjunto(vertice);
        }

        for (Arista arista : aristasOrdenadas) {
            String origen = arista.getOrigen();
            String destino = arista.getDestino();

            boolean formaCiclo = unionFind.estanConectados(origen, destino);

            if (!formaCiclo) {
                resultado.agregarArista(arista);
                unionFind.unir(origen, destino);
            }

            if (resultado.getAristasSeleccionadas().size() == grafo.cantidadVertices() - 1) {
                break;
            }
        }

        return resultado;
    }
}