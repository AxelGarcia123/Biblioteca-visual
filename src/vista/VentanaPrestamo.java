package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.Estante;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Prestamos;
import modelo.TablaPrestamo;

import javax.swing.JComboBox;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaPrestamo extends JPanel implements ActionListener{

	private JLabel lblEnElTecnm;
	private JLabel lblListaDeAlumnos;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNoDeControl;
	private JComboBox<String> datosIsbn;
	private RSDateChooser dateChooser;
	private JTextField editBuscarAlumno;
	private JLabel libro;
	private JLabel lblFechaDeEntrega;
	private RSDateChooser dateChooser_1;
	private JButton botonBuscar;
	private JLabel titulo;
	private JButton botonGuardar;
	private JButton botonCancelar;
	
	public VentanaPrestamo() {
		setLayout(new BorderLayout(30, 20));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 112, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 5, 0));

		lblListaDeAlumnos = new JLabel("Tecnol\u00F3gico Nacional de M\u00E9xico");
		lblListaDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeAlumnos.setForeground(Color.WHITE);
		lblListaDeAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblListaDeAlumnos);

		lblEnElTecnm = new JLabel("Solicitud de Libros");
		lblEnElTecnm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnElTecnm.setForeground(Color.WHITE);
		lblEnElTecnm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblEnElTecnm);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonGuardar.setForeground(Color.WHITE);
		botonGuardar.setBackground(new Color(0, 112, 192));
		panel_1.add(botonGuardar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setBackground(new Color(0, 112, 192));
		panel_1.add(botonCancelar);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 3, 30, 180));
		
		lblNoDeControl = new JLabel("No. de Control:");
		lblNoDeControl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNoDeControl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNoDeControl);
		
		editBuscarAlumno = new JTextField();
		editBuscarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		editBuscarAlumno.addActionListener(this);
		editBuscarAlumno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		editBuscarAlumno.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editBuscarAlumno);
		editBuscarAlumno.setColumns(10);
		
		botonBuscar = new JButton("Buscar");
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setBackground(new Color(0, 112, 192));
		panel_2.add(botonBuscar);
		
		datosIsbn = new JComboBox();
		datosIsbn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2.add(datosIsbn);
		
		libro = new JLabel("T\u00edtulo:");
		libro.setHorizontalAlignment(SwingConstants.CENTER);
		libro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2.add(libro);
		
		titulo = new JLabel("");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2.add(titulo);
		
		lblFechaDeEntrega = new JLabel("Fecha de entrega y devoluci\u00F3n");
		lblFechaDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFechaDeEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblFechaDeEntrega);
		
		dateChooser = new RSDateChooser();
		panel_2.add(dateChooser);
		
		dateChooser_1 = new RSDateChooser();
		panel_2.add(dateChooser_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editBuscarAlumno) {
			if(editBuscarAlumno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else if(editBuscarAlumno.getText().length() != 8)
				JOptionPane.showMessageDialog(null, "Ingrese 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
			else 
				botonBuscar.requestFocus();
		}
	}
	
	public void mostrarDatos(List<Libro> estante, TablaPrestamo prestamo) {
		for (Libro libro : estante) {
			if(!prestamo.existeIsbn(libro.getIsbn())) {
				String isbn = libro.getIsbn();
				datosIsbn.addItem(isbn);
			}
		}
		libro.setText("T\u00edtulo:");
	}
	
	public Prestamo registrarPrestamo() {
		Prestamo prestamo = new Prestamo();
		prestamo.setControlNumber(editBuscarAlumno.getText());
		prestamo.setIsbn(datosIsbn.getSelectedItem().toString());
		
		String formatoFecha = "dd MMMM yyyy";
		Date fecha = dateChooser.getDatoFecha();
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
		
		String formatoFecha1 = "dd MMMM yyyy";
		Date fecha1 = dateChooser_1.getDatoFecha();
		SimpleDateFormat formateador1 = new SimpleDateFormat(formatoFecha1);
		
		prestamo.setFechaPrestamo(formateador.format(fecha));
		prestamo.setFechaEntrega(formateador1.format(fecha1));
		prestamo.setTitle(titulo.getText());
		
		return prestamo;
		
	}
	
	public void limpiar() {
		editBuscarAlumno.setText(null);
		datosIsbn.setModel(new DefaultComboBoxModel());
		libro.setText(null);
		titulo.setText(null);
		dateChooser.setDatoFecha(null);
		dateChooser_1.setDatoFecha(null);
		editBuscarAlumno.requestFocus();
	}
	
	public JButton getBotonBuscar() {
		return botonBuscar;
	}
	
	public JTextField getEditBuscar() {
		return editBuscarAlumno;
	}
	
	public String getDatoBuscar() {
		return editBuscarAlumno.getText();
	}
	
	public JButton getBotonGuardar() {
		return botonGuardar;
	}
	
	public JButton getBotonCancelar() {
		return botonCancelar;
	}
	
	public JComboBox getComboBox() {
		return datosIsbn;
	}
	
	public void enfocarCursor() {
		editBuscarAlumno.requestFocus();
		editBuscarAlumno.setText(null);
	}
	
	public JLabel getTituloLabel() {
		return titulo;
	}
}