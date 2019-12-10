package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Estante;
import modelo.Libro;

public class ReportesLibros extends JPanel {
	private JTable datosGrupo;
	private JLabel lblEnElTecnm;
	private JLabel lblListaDeAlumnos;

	public ReportesLibros() {
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

		lblEnElTecnm = new JLabel("Lista de Libros Registrados");
		lblEnElTecnm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnElTecnm.setForeground(Color.WHITE);
		lblEnElTecnm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblEnElTecnm);
		
		datosGrupo = new JTable();
		JScrollPane panelTabla = new JScrollPane(datosGrupo);
		add(panelTabla, BorderLayout.CENTER);
	}

	public void mostrarConsulta(List<Libro> baseDatos) {
		String[] titulos = {"Isbn", "T\u00edtulo", "Autor", "Editorial",
				"N\u00famero de Edici\u00f3n", "Año de edici\u00f3n", "Idioma", "Pa\u00eds"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (Libro libro : baseDatos) {
			String[] tupla = {libro.getIsbn(), libro.getTitle(), libro.getAuthor(), libro.getEditorial(),
					libro.getNumeroEdition(), libro.getAnioEdicion(), libro.getIdioma(), libro.getPaisDeOrigen()};
			modelo.addRow(tupla);
		}
		datosGrupo.setModel(modelo);
	}
}