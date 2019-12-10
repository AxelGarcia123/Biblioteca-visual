package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import modelo.Alumno;
import modelo.Grupo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaAlumno extends JPanel implements ActionListener{
	private JTextField editBuscar;
	private JButton botonBuscar;
	private JButton botonAceptar;
	private JButton botonSalir;
	private JLabel lblNmeroDeControl;
	private JLabel label_1;
	private JLabel datoNoControl;
	private JLabel label_2;
	private JLabel datoNombre;
	private JLabel label_3;
	private JLabel datoPaterno;
	private JLabel label_4;
	private JLabel datoMaterno;
	private JLabel label_5;
	private JLabel datoGenero;
	private JLabel datoFechaNacimiento;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel datoTelefono;
	private JLabel label_9;
	private JLabel datoEMail;
	private JLabel datoNoCasa;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel datoCalle;
	private JLabel label_12;
	private JLabel datoCodigoPostal;
	private JLabel label_13;
	private JLabel datoColonia;
	private JLabel label_14;
	private JLabel datoCiudad;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel datoCarrera;
	private JLabel datoEstado;
	private JLabel label_17;
	private JLabel datoSemestre;

	public ConsultaAlumno() {
		setLayout(new BorderLayout(0, 10));

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 112, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel label = new JLabel("Biblioteca central del TecNM");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(label);

		JLabel lblConsultaDeLibros = new JLabel("Consulta de Alumnos");
		lblConsultaDeLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeLibros.setForeground(Color.WHITE);
		lblConsultaDeLibros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblConsultaDeLibros);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(Color.WHITE);
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonAceptar.setBackground(new Color(0, 112, 192));
		botonAceptar.addActionListener(this);
		panel_1.add(botonAceptar);

		botonSalir = new JButton("   Salir   ");
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonSalir.setBackground(new Color(0, 112, 192));
		botonSalir.addActionListener(this);
		panel_1.add(botonSalir);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 4, 5, 20));

		lblNmeroDeControl = new JLabel("N\u00FAmero de Control del alumno:");
		lblNmeroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblNmeroDeControl);

		editBuscar = new JTextField();
		editBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		editBuscar.addActionListener(this);
		editBuscar.setBorder(new LineBorder(new Color(0, 112, 192)));
		editBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(editBuscar);
		editBuscar.setColumns(10);
		editBuscar.requestFocus();

		botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(this);
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonBuscar.setBackground(new Color(0, 112, 192));
		panel_2.add(botonBuscar);

		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(label_6);

		label_1 = new JLabel("NO.Control:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_1);

		datoNoControl = new JLabel();
		datoNoControl.setHorizontalAlignment(SwingConstants.LEFT);
		datoNoControl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_2.add(datoNoControl);

		label_2 = new JLabel("Nombre:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_2);

		datoNombre = new JLabel();
		datoNombre.setHorizontalAlignment(SwingConstants.LEFT);
		datoNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoNombre);

		label_3 = new JLabel("Apellido Paterno:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_3);

		datoPaterno = new JLabel();
		datoPaterno.setHorizontalAlignment(SwingConstants.LEFT);
		datoPaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoPaterno);

		label_4 = new JLabel("Apellido Materno");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_4);

		datoMaterno = new JLabel();
		datoMaterno.setHorizontalAlignment(SwingConstants.LEFT);
		datoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoMaterno);

		label_5 = new JLabel("G\u00E9nero:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_5);

		datoGenero = new JLabel();
		datoGenero.setHorizontalAlignment(SwingConstants.LEFT);
		datoGenero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoGenero);

		label_7 = new JLabel("Fecha de Nacimiento:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_7);

		datoFechaNacimiento = new JLabel();
		datoFechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		datoFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoFechaNacimiento);

		label_8 = new JLabel("Tel\u00E9fono:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_8);

		datoTelefono = new JLabel();
		datoTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		datoTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoTelefono);

		label_9 = new JLabel("E-Mail:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_9);

		datoEMail = new JLabel();
		datoEMail.setHorizontalAlignment(SwingConstants.LEFT);
		datoEMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoEMail);

		label_10 = new JLabel("No. Casa:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_10);

		datoNoCasa = new JLabel();
		datoNoCasa.setHorizontalAlignment(SwingConstants.LEFT);
		datoNoCasa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoNoCasa);

		label_11 = new JLabel("Calle:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_11);

		datoCalle = new JLabel();
		datoCalle.setHorizontalAlignment(SwingConstants.LEFT);
		datoCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoCalle);

		label_12 = new JLabel("C\u00F3digo Postal:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_12);

		datoCodigoPostal = new JLabel();
		datoCodigoPostal.setHorizontalAlignment(SwingConstants.LEFT);
		datoCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoCodigoPostal);

		label_13 = new JLabel("Colonia:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_13);

		datoColonia = new JLabel();
		datoColonia.setHorizontalAlignment(SwingConstants.LEFT);
		datoColonia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoColonia);

		label_14 = new JLabel("Ciudad:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_14);

		datoCiudad = new JLabel();
		datoCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		datoCiudad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoCiudad);

		label_15 = new JLabel("Estado:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_15);

		datoEstado = new JLabel();
		datoEstado.setHorizontalAlignment(SwingConstants.LEFT);
		datoEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoEstado);

		label_16 = new JLabel("Carrera:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_16);

		datoCarrera = new JLabel();
		datoCarrera.setHorizontalAlignment(SwingConstants.LEFT);
		datoCarrera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoCarrera);

		label_17 = new JLabel("Semestre:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_17);

		datoSemestre = new JLabel();
		datoSemestre.setHorizontalAlignment(SwingConstants.LEFT);
		datoSemestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(datoSemestre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editBuscar) {
			if(editBuscar.getText().isEmpty() || editBuscar.getText().length() != 8)
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				botonBuscar.requestFocus();
		}
	}

	public void mostrarAlumno(Alumno alumno) {
		datoNoControl.setText(alumno.getControlNumber());
		datoNombre.setText(alumno.getName());
		datoPaterno.setText(alumno.getPaternal());
		datoMaterno.setText(alumno.getMaternal());
		datoGenero.setText(alumno.getSex());
		datoFechaNacimiento.setText(alumno.getFechaNacimiento());
		datoTelefono.setText(alumno.getTelefono());
		datoEMail.setText(alumno.getEmail());
		datoNoCasa.setText(alumno.getAddress().getNumeroCasa());
		datoCalle.setText(alumno.getAddress().getCalle());
		datoCodigoPostal.setText(alumno.getAddress().getCodigoPostal());
		datoColonia.setText(alumno.getAddress().getColonia());
		datoCiudad.setText(alumno.getAddress().getCiudad());
		datoEstado.setText(alumno.getAddress().getEstado());
		datoCarrera.setText(alumno.getCarrera());
		datoSemestre.setText(alumno.getSemestre());
	}

	public JButton getBoton() {
		return botonBuscar;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}

	public void limpiar() {
		datoNoControl.setText(null);
		datoNombre.setText(null);
		datoPaterno.setText(null);
		datoMaterno.setText(null);
		datoGenero.setText(null);
		datoFechaNacimiento.setText(null);
		datoTelefono.setText(null);
		datoEMail.setText(null);
		datoNoCasa.setText(null);
		datoCalle.setText(null);
		datoCodigoPostal.setText(null);
		datoColonia.setText(null);
		datoCiudad.setText(null);
		datoEstado.setText(null);
		datoCarrera.setText(null);
		datoSemestre.setText(null);
	}

	public String getDato() {
		return editBuscar.getText();
	}
	
	public void enfocarCursor() {
		editBuscar.requestFocus();
		editBuscar.setText(null);
	}
}