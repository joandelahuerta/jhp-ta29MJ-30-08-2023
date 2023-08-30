import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio02 {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Ejercicio 02 - Maven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Has pulsado: Ninguno");
        frame.add(label);

        JButton boton1 = new JButton("Botón 1");
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Has pulsado: Botón 1");
            }
        });

        JButton boton2 = new JButton("Botón 2");
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Has pulsado: Botón 2");
            }
        });

        frame.add(boton1);
        frame.add(boton2);

        frame.setVisible(true);
    }
}