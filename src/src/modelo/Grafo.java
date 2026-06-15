package modelo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<String> vertices;
    private List<Arista> aristas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    public void agregarVertice(String vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
        }
    }

    public void agregarArista(String origen, String destino, int peso) {
        agregarVertice(origen);
        agregarVertice(destino);
        aristas.add(new Arista(origen, destino, peso));
    }

    public List<String> getVertices() {
        return vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public int cantidadVertices() {
        return vertices.size();
    }

    public String mostrarGrafo() {
        StringBuilder sb = new StringBuilder();

        sb.append("SUCURSALES:\n");
        for (String vertice : vertices) {
            sb.append("- ").append(vertice).append("\n");
        }

        sb.append("\nCONEXIONES DISPONIBLES:\n");
        for (Arista arista : aristas) {
            sb.append(arista).append("\n");
        }

        return sb.toString();
    }
}
