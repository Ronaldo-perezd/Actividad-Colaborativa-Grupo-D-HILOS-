package uptc.edu.run;

import uptc.edu.logica.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * 
 * Esta clase define la clase principal de interfaz y el runnable
 * 
 * @author: Ronaldo
 * 
 * @version: 07/09/2020/A
 * 
 * 
 */
public class Main {

	// Campos de la clase
	public JFrame frame;
	static ArrayList llegada = new ArrayList();
	static ArrayList ciudad = new ArrayList();
	static ArrayList distancia = new ArrayList();
	static ArrayList valor = new ArrayList();
	static JComboBox comboBox = new JComboBox();
	static JComboBox comboBox_1 = new JComboBox();
	static JButton btnNewButton = new JButton("MOSTRAR RUTA");
	static JButton btnNewButton_1 = new JButton("SALIR");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 519, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("TRANSPORTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(55, 32, 396, 52);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, Color.RED));
		panel.setBounds(10, 11, 483, 397);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CIUDAD DE SALIDA: ");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 117, 191, 37);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("CIUDAD DE LLEGADA: ");
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(29, 168, 191, 37);
		panel.add(lblNewLabel_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz in = new Interfaz();
				in.setVisible(true);
				frame.setVisible(false);

			}
		});

		btnNewButton.setEnabled(false);

		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Bogota", "Madrid", "Paris", "Lima", "Santiago de Chile" }));

		comboBox.setBounds(243, 117, 216, 37);
		panel.add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				int selection = comboBox.getSelectedIndex();
				switch (selection) {
				case 0:
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Paris", "Madrid", "Lima" }));
					distancia.add(0, 8617);
					distancia.add(1, 8007);
					distancia.add(2, 1878);
					valor.add(0, 2500000);
					valor.add(1, 2250000);
					valor.add(2, 1200000);

					break;
				case 1:
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Bogota", "Paris" }));
					distancia.add(0, 8007);
					distancia.add(1, 1268);
					valor.add(0, 1800000);
					valor.add(1, 780000);

					break;

				case 2:
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Madrid" }));
					distancia.add(0, 1268);
					valor.add(0, 680000);

					break;

				case 3:
					comboBox_1.setModel(
							new DefaultComboBoxModel(new String[] { "Bogota", "Paris", "Santiago de Chile" }));
					distancia.add(0, 1878);
					distancia.add(1, 10267);
					distancia.add(2, 2462);
					valor.add(0, 800000);
					valor.add(1, 2800000);
					valor.add(2, 750000);
					break;

				case 4:
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Bogota", "Lima" }));
					distancia.add(0, 4248);
					distancia.add(1, 2462);
					valor.add(0, 1200000);
					valor.add(1, 700000);

					break;

				default:
					break;
				}
			}
		});

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				btnNewButton_1.setEnabled(true);
				btnNewButton.setEnabled(true);
				String seleccion = String.valueOf(comboBox_1.getSelectedItem());
				String salida = String.valueOf(comboBox.getSelectedItem());

				ciudad.add(0, salida);
				llegada.add(0, seleccion);
				textField.setText(salida + " ..");
				textField_1.setText(seleccion + ".."); 
				
				if (salida.equals("Bogota") && seleccion.equals("Paris"))
				{
					textField_2.setText(distancia.get(0).toString());
					textField_3.setText(valor.get(0).toString());
					
				}else if (salida.equals("Bogota") && seleccion.equals("Madrid"))
				{
					textField_2.setText(distancia.get(1).toString());
					textField_3.setText(valor.get(1).toString());
					
				}else if (salida.equals("Bogota") && seleccion.equals("Lima"))
				{
					textField_2.setText(distancia.get(2).toString());
					textField_3.setText(valor.get(2).toString());	
					
				}else if (salida.equals("Madrid") && seleccion.equals("Bogota"))
				{
					textField_2.setText(distancia.get(0).toString());
					textField_3.setText(valor.get(0).toString());
			}
				else if (salida.equals("Madrid") && seleccion.equals("Paris"))
				{
					textField_2.setText(distancia.get(1).toString());
					textField_3.setText(valor.get(1).toString());
				}
				else if (salida.equals("Paris") && seleccion.equals("Madrid"))
				{
					textField_2.setText(distancia.get(0).toString());
					textField_3.setText(valor.get(0).toString());
				}
				else if (salida.equals("Lima") && seleccion.equals("Bogota"))
				{
					textField_2.setText(distancia.get(0).toString());
					textField_3.setText(valor.get(0).toString());
				}
				else if (salida.equals("Lima") && seleccion.equals("Paris"))
				{
					textField_2.setText(distancia.get(1).toString());
					textField_3.setText(valor.get(1).toString());
				}
				else if (salida.equals("Lima") && seleccion.equals("Santiago de Chile"))
				{
					textField_2.setText(distancia.get(2).toString());
					textField_3.setText(valor.get(2).toString());	
				}
				else if (salida.equals("Santiago de Chile") && seleccion.equals("Bogota"))
				{
					textField_2.setText(distancia.get(0).toString());
					textField_3.setText(valor.get(0).toString());
				}
				else if (salida.equals("Santiago de Chile") && seleccion.equals("Lima"))
				{
					textField_2.setText(distancia.get(1).toString());
					textField_3.setText(valor.get(1).toString());
				}
				
				
				

			}

		});

		comboBox_1.setBounds(243, 165, 216, 42);
		panel.add(comboBox_1);

		btnNewButton.setBounds(48, 347, 149, 23);
		panel.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "¡Muchas gracias vuelva pronto!");
				System.exit(0);
			
			}
		});

		btnNewButton_1.setBounds(370, 347, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ruta Recomendable :");
		lblNewLabel_2.setBounds(29, 216, 127, 30);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBorder(new TitledBorder(null, "Ruta Recomendada", TitledBorder.LEADING, TitledBorder.TOP, null, Color.ORANGE));
		panel_1.setBounds(183, 218, 276, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad salida:");
		lblNewLabel_3.setBounds(10, 18, 92, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ciudad llegada:");
		lblNewLabel_3_1.setBounds(10, 43, 92, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Distancia");
		lblNewLabel_3_2.setBounds(10, 68, 92, 14);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Valor :");
		lblNewLabel_3_3.setBounds(10, 93, 92, 14);
		panel_1.add(lblNewLabel_3_3);
		
		textField = new JTextField();
		
		textField.setEditable(false);
		textField.setBounds(117, 15, 149, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(117, 40, 149, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(117, 65, 149, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(117, 90, 149, 20);
		panel_1.add(textField_3);

	}

	public ArrayList getLlegada() {
		return llegada;
	}

	public void setLlegada(ArrayList llegada) {
		this.llegada = llegada;
	}

	public ArrayList getCiudad() {
		return ciudad;
	}

	public void setCiudad(ArrayList ciudad) {
		this.ciudad = ciudad;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
}
