import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio03 {

	private static int contadorBoton1 = 0;
    private static int contadorBoton2 = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Ejercicio 03 - Maven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label1 = new JLabel("Botón 1: 0 veces");
        JLabel label2 = new JLabel("Botón 2: 0 veces");

        JButton boton1 = new JButton("Botón 1");
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contadorBoton1++;
                label1.setText("Botón 1: " + contadorBoton1 + " veces");
            }
        });

        JButton boton2 = new JButton("Botón 2");
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contadorBoton2++;
                label2.setText("Botón 2: " + contadorBoton2 + " veces");
            }
        });

        panelCentro.add(label1);
        panelCentro.add(label2);
        panelCentro.add(boton1);
        panelCentro.add(boton2);

        frame.add(panelCentro, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}