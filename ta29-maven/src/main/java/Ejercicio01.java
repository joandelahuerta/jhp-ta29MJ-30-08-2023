import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ejercicio01 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Ejercicio 01 - Maven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel label = new JLabel("Etiqueta de prueba");
        frame.add(label, BorderLayout.CENTER);

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(closeButton, BorderLayout.SOUTH);

        frame.addWindowListener(new WindowAdapter() {
            public void windowStateChanged(WindowEvent e) {
                int newState = e.getNewState();
                if ((newState & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                    label.setText("Ventana maximizada");
                } else if (newState == Frame.NORMAL) {
                    label.setText("Ventana en tamaño normal");
                }
            }
        });

        frame.setVisible(true);
    }
}

