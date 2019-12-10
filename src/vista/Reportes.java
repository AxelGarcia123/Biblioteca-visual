package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Grupo;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.util.List;

public class Reportes extends JPanel {
	private JTable datosGrupo;
	private JLabel lblEnElTecnm;
	private JLabel lblListaDeAlumnos;

	public Reportes() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 112, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 5, 0));

		lblListaDeAlumnos = new JLabel("Tecnol\u00F3gico Nacional de M\u00E9xico");
		lblListaDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeAlumnos.setForeground(Color.WHITE);
		lblListaDeAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblListaDeAlumnos);

		lblEnElTecnm = new JLabel("Lista de Alumnos Registrados");
		lblEnElTecnm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnElTecnm.setForeground(Color.WHITE);
		lblEnElTecnm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblEnElTecnm);
		
		datosGrupo = new JTable();
		JScrollPane panelTabla = new JScrollPane(datosGrupo);
		add(panelTabla, BorderLayout.CENTER);
	}

	public void mostrarConsulta(List<Alumno> grupo) {
		String[] titulos = {"NO. de Control:", "Nombre:", "Sexo:", "Fecha de Nacimiento:", "Tel\u00e9fono:", "E-Mail", "Carrera", "Semestre","Dirección"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (Alumno alumno : grupo) {
			String nombre = alumno.getName()+ " "+ alumno.getPaternal()+ " "+ alumno.getMaternal();
			
			String direccion = alumno.getAddress().getNumeroCasa()+ " "+ alumno.getAddress().getCalle()+ " "+ 
			alumno.getAddress().getColonia()+ " "+ alumno.getAddress().getCodigoPostal()+ " "+ alumno.getAddress().getCiudad()
			+" "+ alumno.getAddress().getEstado();
			
			String[] tupla = {alumno.getControlNumber(), nombre, alumno.getSex(), alumno.getFechaNacimiento(), alumno.getTelefono(), 
					alumno.getEmail(), alumno.getCarrera(), alumno.getSemestre(), direccion};
			modelo.addRow(tupla);
		}
		datosGrupo.setModel(modelo);
	}
}