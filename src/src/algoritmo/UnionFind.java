package algoritmo;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    private Map<String, String> padre;

    public UnionFind() {
        padre = new HashMap<>();
    }

    public void crearConjunto(String vertice) {
        padre.put(vertice, vertice);
    }

    public String encontrar(String vertice) {
        if (!padre.get(vertice).equals(vertice)) {
            padre.put(vertice, encontrar(padre.get(vertice)));
        }
        return padre.get(vertice);
    }

    public void unir(String verticeA, String verticeB) {
        String raizA = encontrar(verticeA);
        String raizB = encontrar(verticeB);

        if (!raizA.equals(raizB)) {
            padre.put(raizA, raizB);
        }
    }

    public boolean estanConectados(String verticeA, String verticeB) {
        return encontrar(verticeA).equals(encontrar(verticeB));
    }
}
