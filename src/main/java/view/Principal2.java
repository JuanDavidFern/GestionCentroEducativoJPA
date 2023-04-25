package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import controller.MateriaController;
import controller.ProfesorController;
import controller.ValoracionMateriaController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal2 extends JFrame {

	private JPanel contentPane;
	private static JComboBox<Materia> jcbMateria;
	private JLabel lblNewLabel_1;
	private static JComboBox<Profesor> jcbProfesor;
	private JLabel lblNewLabel_2;
	private static JComboBox jcbNota;
	private JButton btnActualizar;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private DefaultListModel<Estudiante> listModelEstudiantes = null;
	private JList jlistEstudiantes;
	private List<Estudiante> estudiantes = EstudianteController.findAll();
	private DefaultListModel<Estudiante> listModelEstudiantes2 = null;
	private JList jlistEstudiantes2;
	private List<Estudiante> estudiantesParaGuardar = new ArrayList<>();
	private JButton btnguardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2();
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
	public Principal2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		contentPane.add(jcbMateria, gbc_jcbMateria);

		lblNewLabel_1 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		contentPane.add(jcbProfesor, gbc_jcbProfesor);

		lblNewLabel_2 = new JLabel("Nota");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		contentPane.add(jcbNota, gbc_jcbNota);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodo2();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		contentPane.add(btnActualizar, gbc_btnActualizar);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel_3 = new JLabel("Alumno no seleccionado ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 4;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Alumno seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 8;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jlistEstudiantes = new JList(this.getDefaultListModel());
		jlistEstudiantes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		jlistEstudiantes2 = new JList(this.getDefaultListModel2());
		jlistEstudiantes2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		scrollPane = new JScrollPane(jlistEstudiantes);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodo2();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionados2();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

		btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);

		btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodo();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);

		scrollPane_1 = new JScrollPane(jlistEstudiantes2);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 8;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);

		btnguardar = new JButton("Guardá");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 5;
		contentPane.add(btnguardar, gbc_btnNewButton_4);

		llenarNota();
		llenarMateria();
		llenarProfesor();
		agregarEstudiantes();

	}

	private void agregarEstudiantes() {
		listModelEstudiantes.removeAllElements();
		listModelEstudiantes.addAll(estudiantes);

	}

	private DefaultListModel getDefaultListModel2() {
		this.listModelEstudiantes2 = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantes2;
	}

	private DefaultListModel getDefaultListModel() {
		this.listModelEstudiantes = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantes;
	}

	private void llenarMateria() {
		List<Materia> lista = MateriaController.findAll();
		for (Materia materia : lista) {
			jcbMateria.addItem(materia);
		}
	}

	private void llenarProfesor() {
		List<Profesor> lista = ProfesorController.findAll();
		for (Profesor profesor : lista) {
			jcbProfesor.addItem(profesor);
		}
	}

	public static void llenarNota() {
		for (int i = 0; i < 11; i++) {
			jcbNota.addItem(Float.parseFloat(i + ""));
		}
	}

	private void cambiarSeleccionados() {
		List<Estudiante> l = jlistEstudiantes.getSelectedValuesList();
		this.listModelEstudiantes2.addAll(l);
		for (int i = this.jlistEstudiantes.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelEstudiantes.removeElementAt(this.jlistEstudiantes.getSelectedIndices()[i]);
		}
	}

	private void cambiarSeleccionados2() {
		this.listModelEstudiantes.addAll(jlistEstudiantes2.getSelectedValuesList());
		for (int i = this.jlistEstudiantes2.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelEstudiantes2.removeElementAt(this.jlistEstudiantes2.getSelectedIndices()[i]);
		}
	}

	private void cambiarTodo() {
//		Object[] a = listModelEstudiantes.toArray();
//		for (Object object : a) {
//			listModelEstudiantes2.addElement((Estudiante)object);
//		}
		listModelEstudiantes.removeAllElements();
		listModelEstudiantes2.removeAllElements();
		listModelEstudiantes2.addAll(estudiantes);
		

	}

	private void cambiarTodo2() {
//		Object[] a = listModelEstudiantes2.toArray();
//		for (Object object : a) {
//			listModelEstudiantes.addElement((Estudiante)object);
//		}
//		listModelEstudiantes2.removeAllElements();
		listModelEstudiantes2.removeAllElements();
		listModelEstudiantes.removeAllElements();
		listModelEstudiantes.addAll(estudiantes);

	}

	private void guardar() {
		
		for (int i = 0; i < listModelEstudiantes2.size(); i++) {
			estudiantesParaGuardar.add(listModelEstudiantes2.getElementAt(i));
		}
		for (Estudiante estudiante : estudiantesParaGuardar) {
			Valoracionmateria v = ValoracionMateriaController.notaEstudianteMateriaProfesor(estudiante,
					(Profesor) jcbProfesor.getSelectedItem(), (Materia) jcbMateria.getSelectedItem());
			if (v != null) {
				v.setValoracion((float) jcbNota.getSelectedItem());
				ValoracionMateriaController.update(v);
			}else {
				v = new Valoracionmateria();
				v.setEstudiante(estudiante);
				v.setMateria((Materia) jcbMateria.getSelectedItem());
				v.setProfesor((Profesor) jcbProfesor.getSelectedItem());
				v.setValoracion((float) jcbNota.getSelectedItem());
				ValoracionMateriaController.insert(v);
			}

		}
	}

}
