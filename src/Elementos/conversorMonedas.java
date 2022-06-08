package Elementos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.management.monitor.StringMonitor;
import javax.print.attribute.standard.JobKOctets;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.nio.channels.CancelledKeyException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class conversorMonedas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conversorMonedas frame = new conversorMonedas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void validaciones(String tipoMoneda, double valor, String resultadoConversion) {
		String datosUsuario = "";
		datosUsuario = JOptionPane.showInputDialog("Numeros");
		try {
			double resultado = Double.valueOf(datosUsuario) / valor;
			DecimalFormat df = new DecimalFormat("#0.00");
			JOptionPane.showInternalMessageDialog(null, datosUsuario + " " + tipoMoneda + " Equivalen a "
					+ df.format(resultado) + " " + resultadoConversion);
			int opciones = JOptionPane.showInternalConfirmDialog(null, "Desea Continuar");
			if (opciones == 0) {
				Main.main(null);
			}

			if (opciones == 1 || opciones == 2) {
				JOptionPane.showMessageDialog(null, "Fin del progama", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(opciones);
			}
		} catch (Exception e) {
			if (datosUsuario == null) {
				JOptionPane.showMessageDialog(null, "Presiono cancelar", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (datosUsuario.equals("")) {
				JOptionPane.showMessageDialog(null, "Escribe algun valor", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Solo se permiten numeros", "Error", JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	/**
	 * Create the frame.
	 */
	public conversorMonedas() {
		setTitle("Conversor De Monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JComboBox seleccionar = new JComboBox();

		seleccionar.setModel(new DefaultComboBoxModel(new String[] { "Peso a Dolar", "Peso a Euro", "Peso a Libras",
				"Peso a Yen", "Dolar a Peso", "Euro a Peso", "Libras a Peso", "Yen a Peso " }));

		JButton btnConfirmar = new JButton("Validar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (seleccionar.getSelectedIndex()) {
				case 0:
					validaciones("Pesos", 3786.68, "Dolares");
					break;
				case 1:
					validaciones("Pesos", 4049.66, "Euros");
					break;
				case 2:
					validaciones("Pesos", 4745.55, "Libras");
					break;
				case 3:
					validaciones("Pesos", 28.70, "Yen");
					break;
				case 4:
					validaciones("Dolar", 0.00026, "Pesos");
					break;
				case 5:
					validaciones("Euros", 0.00025, "Pesos");
					break;
				case 6:
					validaciones("Libras", 0.00021, "Pesos");
					break;
				case 7:
					validaciones("Yen", 0.035, "Pesos");
					break;
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Conversor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(46).addComponent(seleccionar,
										GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(173).addComponent(btnConfirmar))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(152).addComponent(lblNewLabel)))
						.addContainerGap(61, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addGap(35).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE).addComponent(seleccionar,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(44).addComponent(btnConfirmar).addGap(59)));
		contentPane.setLayout(gl_contentPane);
	}
}
