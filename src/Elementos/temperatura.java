package Elementos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class temperatura extends JFrame {

	private JLayeredPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temperatura frame = new temperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public temperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JComboBox seleccionarTemperatura = new JComboBox();
		seleccionarTemperatura.setModel(new DefaultComboBoxModel(
				new String[] { "Grado Celsius a Kelvin", "Grado Celsius a Fahrenheit", "Grado Fahrenheit a Kelvin",
						"Grado Fahrenheit a Celsius", "Grado Kelvin a Celsius", "Grado Kelvin a Fahrenheit" }));

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entrada = "";
				entrada = JOptionPane.showInputDialog("Escriba numero");
				try {
					double salida = Double.valueOf(entrada);
					DecimalFormat df = new DecimalFormat("#0.000");
					switch (seleccionarTemperatura.getSelectedIndex()) {
					case 0:
						double resultado = salida + 273.15;
						JOptionPane.showInternalMessageDialog(null,
								entrada + "°C " + "Equivalen a " + resultado + " °K");
						break;
					case 1:
						double resultado1 = (salida * 9 / 5) + 32;
						JOptionPane.showInternalMessageDialog(null,
								entrada + "°C " + "Equivalen a " + resultado1 + " °F");

						break;
					case 2:
						double resultado2 = (salida - 32) * 5 / 9 + 273.15;
						JOptionPane.showInternalMessageDialog(null,
								entrada + "°F " + "Equivalen a " + df.format(resultado2) + " °K");

						break;
					case 3:
						double resultado3 = (salida - 32) * 5 / 9;
						JOptionPane.showInternalMessageDialog(null,
								entrada + "°F " + "Equivalen a " + df.format(resultado3) + " °C");

						break;
					case 4:
						double resultado4 = salida - 273.15;
						JOptionPane.showInternalMessageDialog(null,
								entrada + "°K " + "Equivalen a " + df.format(resultado4) + " °C");

						break;
					case 5:
						double resultado5 = (salida - 273.15) * 9 / 5 + 32;
						JOptionPane.showInternalMessageDialog(null,
								entrada + "°K " + "Equivalen a " + df.format(resultado5) + " °F");
						break;
					}

					int opciones = JOptionPane.showInternalConfirmDialog(null, "Desea Continuar");
					if (opciones == 0) {
						Main.main(null);
					}

					if (opciones == 1 || opciones == 2) {
						JOptionPane.showMessageDialog(null, "Fin del progama", "Error", JOptionPane.ERROR_MESSAGE);
						System.exit(opciones);
					}
				} catch (Exception e2) {
					if (entrada == null) {
						JOptionPane.showMessageDialog(null, "Presiono cancelar", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (entrada.equals("")) {
						JOptionPane.showMessageDialog(null, "Escribe algun valor", "Error",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Solo se permiten numeros", "Error",
								JOptionPane.WARNING_MESSAGE);
					}

				}

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(159).addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(53).addComponent(seleccionarTemperatura,
								GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(55, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(77, Short.MAX_VALUE)
								.addComponent(seleccionarTemperatura, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(69).addComponent(btnNewButton).addGap(62)));
		contentPane.setLayout(gl_contentPane);
	}

}
