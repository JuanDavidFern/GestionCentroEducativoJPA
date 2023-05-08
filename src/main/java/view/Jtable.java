package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import model.Estudiante;

import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Jtable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panelComodin = new PanelComodin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtable frame = new Jtable();
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
	public Jtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setRightComponent(panelComodin);
		
		table = new JTable(getDatosDeTabla(), getTitulosColumnas());
		scrollPane.setViewportView(table);
		scrollPane.setMinimumSize(new Dimension(100, 100));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				List<Estudiante> personas = EstudianteController.findAll();
				int i = 0;
				for (Estudiante estudiante : personas) {
					if (i == table.getSelectedRow()) {
						PanelComodin.construirPanel(estudiante);
					}
					i++;
				}
			}
		});

	}

	

	/**
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] { "Id", "Nombre", "1� apellido", "2� apellido", "DNI.", "Direccion", "Email", "Telef" };
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> personas = EstudianteController.findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][8];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Estudiante persona = personas.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getApellido1();
			datos[i][3] = persona.getApellido2();
			datos[i][4] = persona.getDni();
			datos[i][5] = persona.getDireccion();
			datos[i][6] = persona.getEmail();
			datos[i][7] = persona.getTelefono();
		}

		return datos;
	}

}
