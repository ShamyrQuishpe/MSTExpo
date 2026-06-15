import controlador.MSTController;

import javax.swing.*;

public class Ventana {
    private JPanel panelPrincipal;
    private JTextArea areaGrafo;
    private JButton btnPrim;
    private JButton btnKruskal;
    private JTextArea areaResultado;

    private MSTController controller;

    public Ventana() {
        controller = new MSTController();

        configurarVentana();
        mostrarGrafoInicial();
        configurarEventos();
    }

    private void configurarVentana() {
        areaGrafo.setEditable(false);
        areaResultado.setEditable(false);

        areaGrafo.setLineWrap(true);
        areaGrafo.setWrapStyleWord(true);

        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
    }

    private void mostrarGrafoInicial() {
        areaGrafo.setText(controller.mostrarGrafo());
    }

    private void configurarEventos() {
        btnPrim.addActionListener(e -> {
            String resultadoPrim = controller.ejecutarPrim();
            areaResultado.setText(resultadoPrim);
        });

        btnKruskal.addActionListener(e -> {
            String resultadoKruskal = controller.ejecutarKruskal();
            areaResultado.setText(resultadoKruskal);
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
