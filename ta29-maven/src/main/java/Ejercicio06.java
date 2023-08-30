import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio06 {

		public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                crearVentana();
	            }
	        });
	    }

	    private static void crearVentana() {
	    	JFrame frame = new JFrame("Calculadora de IMC");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(450, 150);
	        frame.setLayout(new GridLayout(2, 1));

	        JPanel panelCampos = new JPanel(new FlowLayout());
	        JLabel labelPeso = new JLabel("Peso (kg):");
	        JTextField campoPeso = new JTextField(10);

	        JLabel labelAltura = new JLabel("Altura (m):");
	        JTextField campoAltura = new JTextField(10);

	        panelCampos.add(labelPeso);
	        panelCampos.add(campoPeso);
	        panelCampos.add(labelAltura);
	        panelCampos.add(campoAltura);

	        JPanel panelResultados = new JPanel(new FlowLayout());
	        JLabel labelResultado = new JLabel("IMC:");
	        JLabel etiquetaResultado = new JLabel();

	        JButton botonCalcular = new JButton("Calcular");
	        
	        panelResultados.add(botonCalcular);
	        panelResultados.add(labelResultado);
	        panelResultados.add(etiquetaResultado);
	        

	        frame.add(panelCampos);
	        frame.add(panelResultados);

	        botonCalcular.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    double peso = Double.parseDouble(campoPeso.getText());
	                    double altura = Double.parseDouble(campoAltura.getText());
	                    double imc = peso / (altura * altura);

	                    etiquetaResultado.setText(String.format("%.2f", imc));
	                } catch (NumberFormatException ex) {
	                    etiquetaResultado.setText("Error");
	                }
	            }
	        });

	        frame.setVisible(true);
	    }
	}