package vista;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Estante;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Prestamos;

public class ReportePrestamos extends JPanel {
	private JTable datosGrupo;
	private JLabel lblEnElTecnm;
	private JLabel lblListaDeAlumnos;

	public ReportePrestamos() {
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

		lblEnElTecnm = new JLabel("Lista de Pr\u00E9stamos");
		lblEnElTecnm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnElTecnm.setForeground(Color.WHITE);
		lblEnElTecnm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblEnElTecnm);
		
		datosGrupo = new JTable();
		JScrollPane panelTabla = new JScrollPane(datosGrupo);
		add(panelTabla, BorderLayout.CENTER);
	}

	public void mostrarConsulta(List<Prestamo> prestamos) {
		String[] titulos = {"NO. Control", "Isbn", "T\u00edtulo", "Fecha de Pr\u00e9stamo",
				"Fecha de entrega"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (Prestamo prestamo : prestamos) {
			String[] tupla = {prestamo.getcontrolNumber(), prestamo.getIsbn(), prestamo.getTitle(), prestamo.getFechaPrestamo(), prestamo.getFechaEntrega()};
			modelo.addRow(tupla);
		}
		datosGrupo.setModel(modelo);
	}
}