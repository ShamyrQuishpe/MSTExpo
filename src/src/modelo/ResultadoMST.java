package modelo;

import java.util.ArrayList;
import java.util.List;

public class ResultadoMST {

    private List<Arista> aristasSeleccionadas;
    private int costoTotal;
    private String nombreAlgoritmo;

    public ResultadoMST(String nombreAlgoritmo) {
        this.nombreAlgoritmo = nombreAlgoritmo;
        this.aristasSeleccionadas = new ArrayList<>();
        this.costoTotal = 0;
    }

    public void agregarArista(Arista arista) {
        aristasSeleccionadas.add(arista);
        costoTotal += arista.getPeso();
    }

    public List<Arista> getAristasSeleccionadas() {
        return aristasSeleccionadas;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public String getNombreAlgoritmo() {
        return nombreAlgoritmo;
    }

    public String mostrarResultado() {
        StringBuilder sb = new StringBuilder();

        sb.append("RESULTADO DEL ALGORITMO DE ")
                .append(nombreAlgoritmo.toUpperCase())
                .append("\n\n");

        sb.append("Conexiones seleccionadas:\n");

        for (Arista arista : aristasSeleccionadas) {
            sb.append("- ").append(arista).append("\n");
        }

        sb.append("\nCosto mínimo total: ").append(costoTotal);

        return sb.toString();
    }
}