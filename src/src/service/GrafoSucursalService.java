package servicio;

import modelo.Grafo;

public class GrafoSucursalService {

    public Grafo crearGrafoDeSucursales() {
        Grafo grafo = new Grafo();

        grafo.agregarArista("Quito", "Guayaquil", 10);
        grafo.agregarArista("Quito", "Cuenca", 6);
        grafo.agregarArista("Quito", "Manta", 8);

        grafo.agregarArista("Guayaquil", "Manta", 5);
        grafo.agregarArista("Guayaquil", "Loja", 12);

        grafo.agregarArista("Cuenca", "Loja", 4);
        grafo.agregarArista("Cuenca", "Manta", 7);

        grafo.agregarArista("Manta", "Loja", 9);

        return grafo;
    }
}