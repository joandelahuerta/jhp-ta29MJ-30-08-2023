import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio05 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Ejercicio 05 - Maven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JButton botonLimpiar = new JButton("Limpiar");
        JTextArea areaTexto = new JTextArea();

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonLimpiar);

        frame.add(panelBoton, BorderLayout.NORTH);
        frame.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        areaTexto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String evento = "Clic del ratón\n";
                areaTexto.append(evento);
            }

            public void mouseEntered(MouseEvent e) {
                String evento = "El ratón ha entrado en el compomente\n";
                areaTexto.append(evento);
            }

            public void mouseExited(MouseEvent e) {
                String evento = "El ratón ha salido del compomente\n";
                areaTexto.append(evento);
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("");
            }
        });

        frame.setVisible(true);
    }
}