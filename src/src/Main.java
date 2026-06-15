

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Árbol de Expansión Mínima - Prim y Kruskal");

        frame.setContentPane(new Ventana().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}