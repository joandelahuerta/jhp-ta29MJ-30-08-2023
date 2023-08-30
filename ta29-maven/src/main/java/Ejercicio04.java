import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio04 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Ejercicio 04 - Maven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Eventos:");
        frame.add(label, BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea();
        frame.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                areaTexto.append("Ventana abierta\n");
            }

            public void windowClosing(WindowEvent e) {
                areaTexto.append("Ventana cerrándose\n");
            } //no sale ya que se cierra pero lo pongo por si acaso

            public void windowClosed(WindowEvent e) {
                areaTexto.append("Evento: Ventana cerrada\n");
            } //no sale ya que se cierra pero lo pongo por si acaso

            public void windowIconified(WindowEvent e) {
                areaTexto.append("Ventana minimizada\n");
            }

            public void windowDeiconified(WindowEvent e) {
                areaTexto.append("Ventana restaurada\n");
            }

            public void windowActivated(WindowEvent e) {
                areaTexto.append("Ventana activada\n");
            }

            public void windowDeactivated(WindowEvent e) {
                areaTexto.append("Evento: Ventana desactivada\n");
            }
        });

        frame.setVisible(true);
    }
}