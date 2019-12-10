package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.Devolucion;
import modelo.Prestamo;
import modelo.Prestamos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaDevoluciones extends JPanel implements ActionListener{

	private JPanel panel_1;
	private JLabel lblListaDeAlumnos;
	private JLabel lblEnElTecnm;
	private JButton botonDevolver;
	private JButton botonCancelar;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblEscribaElIsbn;
	private JTextField editIsbn;
	private JButton botonBuscar;
	private JLabel lblNmeroDeControl;
	private JLabel lblIsbn;
	private JLabel lblTtulo;
	private JLabel lblFechaDePrstamo;
	private JLabel lblFechaDeEntrega;
	private JLabel datoNoControl;
	private JLabel datoIsbn;
	private JLabel datoTitulo;
	private JLabel datoFechaPrestamo;
	private JLabel datoFechaEntrega;
	
	public VentanaDevoluciones() {
		setLayout(new BorderLayout(0, 10));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 112, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 5, 0));

		lblListaDeAlumnos = new JLabel("Tecnol\u00F3gico Nacional de M\u00E9xico");
		lblListaDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeAlumnos.setForeground(Color.WHITE);
		lblListaDeAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblListaDeAlumnos);

		lblEnElTecnm = new JLabel("Devoluci\u00F3n de Libros");
		lblEnElTecnm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnElTecnm.setForeground(Color.WHITE);
		lblEnElTecnm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblEnElTecnm);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		botonDevolver = new JButton("Devolver");
		botonDevolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonDevolver.setForeground(Color.WHITE);
		botonDevolver.setBackground(new Color(0, 112, 192));
		panel_1.add(botonDevolver);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setBackground(new Color(0, 112, 192));
		panel_1.add(botonCancelar);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 3, 10, 0));
		
		lblEscribaElIsbn = new JLabel("Escriba el Isbn:");
		lblEscribaElIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEscribaElIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblEscribaElIsbn);
		
		editIsbn = new JTextField();
		editIsbn.addActionListener(this);
		editIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		editIsbn.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_3.add(editIsbn);
		editIsbn.setColumns(10);
		
		botonBuscar = new JButton("Buscar");
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setBackground(new Color(0, 112, 192));
		panel_3.add(botonBuscar);
		
		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(5, 2, 10, 10));
		
		lblNmeroDeControl = new JLabel("N\u00FAmero de Control:");
		lblNmeroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmeroDeControl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNmeroDeControl);
		
		datoNoControl = new JLabel("");
		datoNoControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datoNoControl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(datoNoControl);
		
		lblIsbn = new JLabel("Isbn:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblIsbn);
		
		datoIsbn = new JLabel("");
		datoIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datoIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(datoIsbn);
		
		lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTtulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblTtulo);
		
		datoTitulo = new JLabel("");
		datoTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(datoTitulo);
		
		lblFechaDePrstamo = new JLabel("Fecha de Pr\u00E9stamo:");
		lblFechaDePrstamo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDePrstamo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblFechaDePrstamo);
		
		datoFechaPrestamo = new JLabel("");
		datoFechaPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datoFechaPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(datoFechaPrestamo);
		
		lblFechaDeEntrega = new JLabel("Fecha de Entrega:");
		lblFechaDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDeEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblFechaDeEntrega);
		
		datoFechaEntrega = new JLabel("");
		datoFechaEntrega.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datoFechaEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(datoFechaEntrega);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editIsbn) {
			if(editIsbn.getText() == null || editIsbn.getText().length() != 15)
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio y debe tener 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
			else
				botonBuscar.requestFocus();
		}
	}
	
	public JTextField getCampoBuscar() {
		return editIsbn;
	}
	
	public JButton getBotonBuscar() {
		return botonBuscar;
	}
	
	public void mostrarDatos(Prestamo prestamo) {
			datoNoControl.setText(prestamo.getcontrolNumber());
			datoIsbn.setText(prestamo.getIsbn());
			datoTitulo.setText(prestamo.getTitle());
			datoFechaPrestamo.setText(prestamo.getFechaPrestamo());
			datoFechaEntrega.setText(prestamo.getFechaEntrega());
			botonDevolver.requestFocus();
	}
	
	public Devolucion devolverLibro() {
		Devolucion devolucion = new Devolucion();
		devolucion.setControlNumber(datoNoControl.getText());
		devolucion.setIsbn(datoIsbn.getText());
		devolucion.setTitle(datoTitulo.getText());
		devolucion.setFechaPrestamo(datoFechaPrestamo.getText());
		devolucion.setFechaEntrega(datoFechaEntrega.getText());
		
		return devolucion;
	}
	
	public void limpiarCampos() {
		datoNoControl.setText(null);
		datoIsbn.setText(null);
		datoTitulo.setText(null);
		datoFechaPrestamo.setText(null);
		datoFechaEntrega.setText(null);
		editIsbn.setText(null);
		editIsbn.requestFocus();
	}
	
	public JButton getBotonDevolver() {
		return botonDevolver;
	}
	
	public void enfocarFoco() {
		editIsbn.requestFocus();
	}
	
	public String getDatoIsbn() {
		return datoIsbn.getText();
	}
	
	public JButton getBotonCancelar() {
		return botonCancelar;
	}
}