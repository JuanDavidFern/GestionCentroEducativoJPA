package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EstudianteController;
import model.Estudiante;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PanelComodin extends JPanel {
	private static JTextField jtfId =  new JTextField();
	private static JTextField jtfnombre;
	private static JTextField jtfape1;
	private static JTextField jtfape2;
	private static JTextField jtfdni;
	private static JTextField jtfdirec;
	private static JTextField jtfemail;
	private static JTextField jtftelef;
	private static Estudiante es = new Estudiante();
	private JButton btnGuardar;

	/**
	 * Create the panel.
	 */
	public PanelComodin() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);


		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfnombre = new JTextField();
		GridBagConstraints gbc_jtfnombre = new GridBagConstraints();
		gbc_jtfnombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfnombre.weightx = 1.0;
		gbc_jtfnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfnombre.gridx = 1;
		gbc_jtfnombre.gridy = 0;
		add(jtfnombre, gbc_jtfnombre);
		jtfnombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido1");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfape1 = new JTextField();
		GridBagConstraints gbc_jtfape1 = new GridBagConstraints();
		gbc_jtfape1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfape1.weightx = 1.0;
		gbc_jtfape1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfape1.gridx = 1;
		gbc_jtfape1.gridy = 1;
		add(jtfape1, gbc_jtfape1);
		jtfape1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Apellido2");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfape2 = new JTextField();
		GridBagConstraints gbc_jtfape2 = new GridBagConstraints();
		gbc_jtfape2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfape2.weightx = 1.0;
		gbc_jtfape2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfape2.gridx = 1;
		gbc_jtfape2.gridy = 2;
		add(jtfape2, gbc_jtfape2);
		jtfape2.setColumns(10);
		
		
				JLabel lblNewLabel_4 = new JLabel("DNI");
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_4.gridx = 0;
				gbc_lblNewLabel_4.gridy = 3;
				add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				jtfdni = new JTextField();
				GridBagConstraints gbc_jtfdni = new GridBagConstraints();
				gbc_jtfdni.insets = new Insets(0, 0, 5, 0);
				gbc_jtfdni.weightx = 1.0;
				gbc_jtfdni.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfdni.gridx = 1;
				gbc_jtfdni.gridy = 3;
				add(jtfdni, gbc_jtfdni);
				jtfdni.setColumns(10);
		
				JLabel lblNewLabel_5 = new JLabel("Direccion");
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_5.gridx = 0;
				gbc_lblNewLabel_5.gridy = 4;
				add(lblNewLabel_5, gbc_lblNewLabel_5);
		
				jtfdirec = new JTextField();
				GridBagConstraints gbc_jtfdirec = new GridBagConstraints();
				gbc_jtfdirec.insets = new Insets(0, 0, 5, 0);
				gbc_jtfdirec.weightx = 1.0;
				gbc_jtfdirec.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfdirec.gridx = 1;
				gbc_jtfdirec.gridy = 4;
				add(jtfdirec, gbc_jtfdirec);
				jtfdirec.setColumns(10);
		
				JLabel lblNewLabel_6 = new JLabel("Email");
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_6.gridx = 0;
				gbc_lblNewLabel_6.gridy = 5;
				add(lblNewLabel_6, gbc_lblNewLabel_6);
		
				jtfemail = new JTextField();
				GridBagConstraints gbc_jtfemail = new GridBagConstraints();
				gbc_jtfemail.insets = new Insets(0, 0, 5, 0);
				gbc_jtfemail.weightx = 1.0;
				gbc_jtfemail.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfemail.gridx = 1;
				gbc_jtfemail.gridy = 5;
				add(jtfemail, gbc_jtfemail);
				jtfemail.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Telefono");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 6;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtftelef = new JTextField();
		GridBagConstraints gbc_jtftelef = new GridBagConstraints();
		gbc_jtftelef.insets = new Insets(0, 0, 5, 0);
		gbc_jtftelef.weightx = 1.0;
		gbc_jtftelef.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtftelef.gridx = 1;
		gbc_jtftelef.gridy = 6;
		add(jtftelef, gbc_jtftelef);
		jtftelef.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 7;
		add(btnGuardar, gbc_btnGuardar);

	
	}
	
	public static void guardar() {
		es.setApellido1(getApellido1());
		es.setApellido2(getApellido2());
		es.setDireccion(getDireccion());
		es.setDni(getDNI());
		es.setEmail(getEmail());
		es.setId(getId());
		es.setTelefono(getTelefono());
		es.setNombre(getNombre());
		EstudianteController.update(es);
		
	}
	
	
;
	/**
	 * 
	 * @param id
	 */
	public static void setId(int id) {

		jtfId.setText("" + id);

	}

	/** @return */

	public static int getId() {

		return Integer.parseInt(jtfId.getText());

	}

	/**
	 * 
	 * @param nombre
	 */
	public static void setNombre(String nombre) {
		jtfnombre.setText(nombre);

	}

	/** @return */

	public static String getNombre() {

		return jtfnombre.getText();

	}

	/**
	 * 
	 * @param apellido1
	 */
	public static void setApellido1(String apellido1) {
		jtfape1.setText(apellido1);

	}

	/** @return */

	public static String getApellido1() {

		return jtfape1.getText();

	}

	/**
	 * 
	 * @param apellido1
	 */
	public static void setApellido2(String apellido2) {
		jtfape2.setText(apellido2);

	}

	/** @return */

	public static String getApellido2() {

		return jtfape2.getText();

	}

	/**
	 * 
	 * @param apellido1
	 */
	public static void setDNI(String dni) {
		jtfdni.setText(dni);

	}

	/** @return */

	public static String getDNI() {

		return jtfdni.getText();

	}

	/**
	 * 
	 * @param apellido1
	 */
	public static void setDireccion(String direccion) {
		jtfdirec.setText(direccion);

	}

	/** @return */

	public static String getDireccion() {

		return jtfdirec.getText();

	}

	/**
	 * 
	 * @param apellido1
	 */
	public static void setEmail(String email) {
		jtfemail.setText(email);

	}

	/** @return */

	public static String getEmail() {

		return jtfemail.getText();

	}

	/**
	 * 
	 * @param apellido1
	 */
	public static void setTelefono(String telefono) {
		jtftelef.setText(telefono);

	}

	/** @return */

	public static String getTelefono() {

		return jtftelef.getText();

	}
	
	public static void construirPanel(Estudiante e) {
		setNombre(e.getNombre());
		setId(e.getId());
		setApellido1(e.getApellido1());
		setApellido2(e.getApellido2());
		setDireccion(e.getDireccion());
		setDNI(e.getDni());
		setEmail(e.getEmail());
		setTelefono(e.getTelefono());
	}

	

}
