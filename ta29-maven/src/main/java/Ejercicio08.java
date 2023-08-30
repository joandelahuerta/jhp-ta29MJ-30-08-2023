import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio08 {
	private static double FACTOR_CONVERSION = 166.386; // 1 euro a pesetas
    private static boolean convertirAPesetas = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Conversor de Moneda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5, 1));

        JPanel panelCantidad = new JPanel(new FlowLayout());
        JLabel labelCantidad = new JLabel("Cantidad:");
        JTextField campoCantidad = new JTextField(10);
        JLabel labelResultado = new JLabel("Resultado:");
        panelCantidad.add(labelCantidad);
        panelCantidad.add(campoCantidad);
        panelCantidad.add(labelResultado);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonMoneda = new JButton("Convertir a Pesetas");
        JButton botonConvertir = new JButton("Convertir");
        JButton botonBorrar = new JButton("Borrar");
        panelBotones.add(botonMoneda);
        panelBotones.add(botonConvertir);
        panelBotones.add(botonBorrar);

        frame.add(panelCantidad);
        frame.add(panelBotones);
        
        botonMoneda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (convertirAPesetas) {
                    botonMoneda.setText("Convertir a Euros");
                } else {
                    botonMoneda.setText("Convertir a Pesetas");
                }
                convertirAPesetas = !convertirAPesetas;
            }
        });

        botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMoneda(campoCantidad, labelResultado);
            }
        });

        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoCantidad.setText("");
                labelResultado.setText("Resultado:");
            }
        });

        campoCantidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMoneda(campoCantidad, labelResultado);
            }
        });

        frame.getRootPane().setDefaultButton(botonConvertir); // Activar botón predeterminado con Enter

        frame.setVisible(true);
    }

    private static void convertirMoneda(JTextField campoCantidad, JLabel labelResultado) {
        try {
            double cantidad = Double.parseDouble(campoCantidad.getText());
            double resultado = 0.0;

            if (convertirAPesetas) {
                resultado = cantidad * FACTOR_CONVERSION;
                labelResultado.setText("Resultado: " + resultado + " pesetas");
            } else {
                resultado = cantidad / FACTOR_CONVERSION;
                labelResultado.setText("Resultado: " + resultado + " euros");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número en formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}