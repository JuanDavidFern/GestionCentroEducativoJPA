package view;

import javax.swing.JPanel;

import controller.EstudianteController;
import controller.MateriaController;
import controller.ProfesorController;
import controller.ValoracionMateriaController;
import model.Estudiante;
import model.Materia;
import model.Profesor;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MateriasCalificacionesView extends JPanel {
	
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Materia> jcbMateria;
	private JPanel panelACargar;
	private List<FichaEstudianteView> vm;
	/**
	 * Create the panel.
	 */
	public MateriasCalificacionesView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		jcbMateria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox<Profesor>();
		jcbProfesor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.weightx = 1.0;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JButton btnNewButton = new JButton("Cargar Alumnos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAlumnos();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		panelACargar = new JPanel();
		GridBagConstraints gbc_panelACargar = new GridBagConstraints();
		gbc_panelACargar.weighty = 1.0;
		gbc_panelACargar.gridwidth = 3;
		gbc_panelACargar.insets = new Insets(0, 0, 0, 5);
		gbc_panelACargar.fill = GridBagConstraints.BOTH;
		gbc_panelACargar.gridx = 0;
		gbc_panelACargar.gridy = 3;
		add(panelACargar, gbc_panelACargar);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (FichaEstudianteView f : vm) {
					if(f.guardar().getValoracion() != -1 && f.guardar().getId() != 0)
						ValoracionMateriaController.update(f.guardar());
					else if(f.guardar().getValoracion() != -1 && f.guardar().getId() == 0)
						ValoracionMateriaController.insert(f.guardar());
					System.out.println(f.toString()+" "+f.guardar().getValoracion()+" "+f.guardar().getId());
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.insets = new Insets(10, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		this.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		llenarMateria();
		llenarProfesor();
		
	}

	private void llenarMateria() {
		List<Materia> lista = MateriaController.findAll();
		for (Materia materia : lista) {
			jcbMateria.addItem(materia);
		}
	}
	
	private void llenarProfesor() {
		List <Profesor> lista = ProfesorController.findAll();
		for (Profesor profesor : lista) {
			jcbProfesor.addItem(profesor);
		}
	}

	private void cargarAlumnos() {
		List<Estudiante> lista = EstudianteController.findAll();
		this.panelACargar.removeAll();
		vm = new ArrayList<FichaEstudianteView>();
		int cont = 3;
		for (Estudiante estudiante : lista) {
			FichaEstudianteView estudiante1 = new FichaEstudianteView(estudiante, (Materia)jcbMateria.getSelectedItem(), (Profesor)jcbProfesor.getSelectedItem());
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 3;
			gbc_panel.insets = new Insets(10, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = cont;
			panelACargar.add(estudiante1, gbc_panel);
			cont++;
			this.repaint();
			this.revalidate();
			vm.add(estudiante1);
//			System.out.println(vm.toString());

		}
		
	}
}
