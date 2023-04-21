package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;

import controller.ValoracionMateriaController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.Insets;
import java.awt.Color;

public class FichaEstudianteView extends JPanel {
	private JTextField jtfNota;
	
	private Estudiante estudiante;
	private Materia materia;
	private Profesor profesor;
	
	/**
	 * Create the panel.
	 */
	public FichaEstudianteView(Estudiante e, Materia m, Profesor p) {
		
		this.estudiante = e;
		this.materia = m;
		this.profesor = p;
		
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel(e.getNombre()+" "+e.getApellido1()+" "+e.getApellido2());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		jtfNota = new JTextField();
		jtfNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfNota = new GridBagConstraints();
		gbc_jtfNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNota.gridx = 1;
		gbc_jtfNota.gridy = 0;
		add(jtfNota, gbc_jtfNota);
		jtfNota.setColumns(10);
		jtfNota.setText(ValoracionMateriaController.notaEstudianteMateriaProfesor(this.estudiante, this.profesor, this.materia) != null 
				? ""+ValoracionMateriaController.notaEstudianteMateriaProfesor(this.estudiante, this.profesor, this.materia).getValoracion() : "");

		
	}
	
	public Valoracionmateria guardar() {
		Valoracionmateria vm = new Valoracionmateria();
		Valoracionmateria m = ValoracionMateriaController.notaEstudianteMateriaProfesor(this.estudiante, this.profesor, this.materia);
		if(m != null) {
			vm.setEstudiante(estudiante);
			vm.setMateria(materia);
			vm.setProfesor(profesor);
			if(!jtfNota.getText().isEmpty())
				vm.setValoracion(Float.parseFloat(jtfNota.getText()));
			else
				vm.setValoracion(-1);
			vm.setId(m.getId());
		}
		else {
			vm.setEstudiante(estudiante);
			vm.setMateria(materia);
			vm.setProfesor(profesor);
			if(!jtfNota.getText().isEmpty())
				vm.setValoracion(Float.parseFloat(jtfNota.getText()));
			else
				vm.setValoracion(-1);
		}
		return vm;
	}

	@Override
	public String toString() {
		return 	estudiante.getNombre() + " " + materia.getNombre()
				+ " " + profesor.getNombre();
	}
	
	

}
