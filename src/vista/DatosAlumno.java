package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Alumno;
import modelo.Cargador;
import modelo.CodigoPostal;
import modelo.Domicilio;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import codigospostales.VistaLista;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class DatosAlumno extends JPanel implements ActionListener{
	private JTextField editNoControl;
	private JTextField editNombre;
	private JTextField editApellidoPaterno;
	private JTextField editApellidoMaterno;
	private JTextField editNoCasa;
	private JTextField editCalle;
	private JTextField editCiudad;
	private JTextField editEstado;
	private JLabel noControl;
	private JLabel apellidoPaterno;
	private JLabel genero;
	private JLabel fechaNacimiento;
	private JLabel calle;
	private JLabel colonia;
	private JLabel estado;
	private JRadioButton editMasculino;
	private JLabel nombre;
	private JLabel apellidoMaterno;
	private JLabel telefono;
	private JLabel noCasa;
	private JLabel codigoPostal;
	private JLabel ciudad;
	private JRadioButton editFemenino;
	private JButton botonGuardar;
	private JButton botonCancelar;
	private RSDateChooser dateChooser;
	private JTextField editTelefono;
	private JTextField editEMail;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblControlDeAlumnos;
	private JLabel semestre;
	private JComboBox<String> editCarrera;
	private JLabel lblSemestre;
	private JButton buscar;
	private VistaLista datosCodigo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField editColonia;
	private String codPostal = "";
	private JTextField editSemestre;

	public DatosAlumno() throws FileNotFoundException {
		setLayout(new BorderLayout(5, 5));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		botonGuardar = new JButton("Guardar");
		botonGuardar.setForeground(Color.WHITE);
		botonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonGuardar.setBackground(new Color(0, 112, 192));
		panel.add(botonGuardar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCancelar.setBackground(new Color(0, 112, 192));
		panel.add(botonCancelar);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 4, 5, 20));

		noControl = new JLabel("NO.Control:");
		noControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(noControl);

		editNoControl = new JTextField();
		editNoControl.setHorizontalAlignment(SwingConstants.CENTER);
		editNoControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validarNumeroControl();
			}
		});
		editNoControl.addActionListener(this);
		editNoControl.setBorder(new LineBorder(new Color(0, 112, 192)));
		editNoControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(editNoControl);
		editNoControl.setColumns(10);

		nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(nombre);

		editNombre = new JTextField();
		editNombre.setHorizontalAlignment(SwingConstants.CENTER);
		editNombre.addActionListener(this);
		editNombre.setBorder(new LineBorder(new Color(0, 112, 192)));
		editNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editNombre.setColumns(10);
		panel_1.add(editNombre);

		apellidoPaterno = new JLabel("Apellido Paterno:");
		apellidoPaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(apellidoPaterno);

		editApellidoPaterno = new JTextField();
		editApellidoPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		editApellidoPaterno.addActionListener(this);
		editApellidoPaterno.setBorder(new LineBorder(new Color(0, 112, 192)));
		editApellidoPaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editApellidoPaterno.setColumns(10);
		panel_1.add(editApellidoPaterno);

		apellidoMaterno = new JLabel("Apellido Materno");
		apellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(apellidoMaterno);

		editApellidoMaterno = new JTextField();
		editApellidoMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		editApellidoMaterno.addActionListener(this);
		editApellidoMaterno.setBorder(new LineBorder(new Color(0, 112, 192)));
		editApellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editApellidoMaterno.setColumns(10);
		panel_1.add(editApellidoMaterno);

		genero = new JLabel("G\u00E9nero:");
		genero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(genero);

		ButtonGroup grupo = new ButtonGroup();

		editMasculino = new JRadioButton("Masculino");
		editMasculino.addActionListener(this);
		editMasculino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(editMasculino);
		grupo.add(editMasculino);

		JLabel label = new JLabel("");
		panel_1.add(label);

		editFemenino = new JRadioButton("Femenino");
		editFemenino.addActionListener(this);
		editFemenino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(editFemenino);
		grupo.add(editFemenino);

		fechaNacimiento = new JLabel("Fecha de Nacimiento:");
		fechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(fechaNacimiento);

		dateChooser = new RSDateChooser();
		dateChooser.setFuente(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(dateChooser);

		telefono = new JLabel("Tel\u00E9fono:");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(telefono);

		editTelefono = new JTextField();
		editTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		editTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editTelefono.addActionListener(this);
		editTelefono.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_1.add(editTelefono);
		editTelefono.setColumns(10);

		JLabel eMail = new JLabel("E-Mail:");
		eMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(eMail);

		editEMail = new JTextField();
		editEMail.setHorizontalAlignment(SwingConstants.CENTER);
		editEMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editEMail.addActionListener(this);
		editEMail.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_1.add(editEMail);
		editEMail.setColumns(10);

		noCasa = new JLabel("No. Casa:");
		noCasa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(noCasa);

		editNoCasa = new JTextField();
		editNoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		editNoCasa.addActionListener(this);
		editNoCasa.setBorder(new LineBorder(new Color(0, 112, 192)));
		editNoCasa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(editNoCasa);
		editNoCasa.setColumns(10);

		calle = new JLabel("Calle:");
		calle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(calle);

		editCalle = new JTextField();
		editCalle.setHorizontalAlignment(SwingConstants.CENTER);
		editCalle.addActionListener(this);
		editCalle.setBorder(new LineBorder(new Color(0, 112, 192)));
		editCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editCalle.setColumns(10);
		panel_1.add(editCalle);

		codigoPostal = new JLabel("C\u00F3digo Postal:");
		codigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(codigoPostal);

		buscar = new JButton("Buscar");
		buscar.addActionListener(this);
		buscar.setForeground(Color.WHITE);
		buscar.setBackground(new Color(0, 112, 192));
		buscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(buscar);

		colonia = new JLabel("Colonia:");
		colonia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(colonia);

		editColonia = new JTextField();
		editColonia.setHorizontalAlignment(SwingConstants.CENTER);
		editColonia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editColonia.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_1.add(editColonia);
		editColonia.setColumns(10);

		ciudad = new JLabel("Ciudad:");
		ciudad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(ciudad);

		editCiudad = new JTextField();
		editCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		editCiudad.addActionListener(this);
		editCiudad.setBorder(new LineBorder(new Color(0, 112, 192)));
		editCiudad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editCiudad.setColumns(10);
		panel_1.add(editCiudad);

		estado = new JLabel("Estado:");
		estado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(estado);

		editEstado = new JTextField();
		editEstado.setHorizontalAlignment(SwingConstants.CENTER);
		editEstado.addActionListener(this);
		editEstado.setBorder(new LineBorder(new Color(0, 112, 192)));
		editEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editEstado.setColumns(10);
		panel_1.add(editEstado);

		semestre = new JLabel("Carrera:");
		semestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(semestre);

		editCarrera = new JComboBox();
		editCarrera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editCarrera.setModel(new DefaultComboBoxModel(new String[] {"Arquitectura", "Contador P\u00FAblico", "Gesti\u00F3n Empresarial", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Electromec\u00E1nica", "Ingenier\u00EDa en Industrias Alimentarias", "Ingenier\u00EDa en Innovaci\u00F3n Agr\u00EDcola Sustentable", "Ingenier\u00EDa en Sistemas Computacionales", "Ingenier\u00EDa Industrial", "Licenciatura en Administraci\u00F3n"}));
		editCarrera.addActionListener(this);
		panel_1.add(editCarrera);

		lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblSemestre);

		editSemestre = new JTextField();
		editSemestre.setHorizontalAlignment(SwingConstants.CENTER);
		editSemestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSemestre.setBorder(new LineBorder(new Color(0, 112, 192)));
		editSemestre.addActionListener(this);
		panel_1.add(editSemestre);
		editSemestre.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 112, 192));
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(2, 1, 5, 0));

		lblNewLabel = new JLabel("Registro de Alumnos del TecNM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_2.add(lblNewLabel);

		lblControlDeAlumnos = new JLabel("Control de Alumnos");
		lblControlDeAlumnos.setForeground(Color.WHITE);
		lblControlDeAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblControlDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblControlDeAlumnos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean bandera = true;
		if(e.getSource() == editNoControl) {
			if(editNoControl.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo \"NO. Control\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else if(editNoControl.getText().length() != 8) {
				JOptionPane.showMessageDialog(null, "El campo \"NO. Control\" debe de tener 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
				editNoControl.setText(null);
				editNoControl.requestFocus();
			}
			else 
				editNombre.requestFocus();

		}

		if(e.getSource() == editNombre) {
			if(editNombre.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo \"Nombre\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else if(!editNombre.getText().isEmpty() && editNombre.getText().charAt(editNombre.getText().length() - 1) == 'o') {
				bandera = false;
				editMasculino.setSelected(true);
				editApellidoPaterno.requestFocus();
			}
			else if(!editNombre.getText().isEmpty() && editNombre.getText().charAt(editNombre.getText().length() - 1) == 'a') {
				editNombre.setText(ucFirst(editNombre.getText()));
				bandera = false;
				editFemenino.setSelected(true);
				editApellidoPaterno.requestFocus();
			}
			else {
				editNombre.setText(ucFirst(editNombre.getText()));
				editApellidoPaterno.requestFocus();
			}
		}

		if(e.getSource() == editApellidoPaterno) {
			if(editApellidoPaterno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo \"Apellido Paterno\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else {
				editApellidoPaterno.setText(ucFirst(editApellidoPaterno.getText()));
				editApellidoMaterno.requestFocus();
			}
		}

		if(e.getSource() == editApellidoMaterno) {
			if(editApellidoMaterno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo \"Apellido Materno\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else {
				editApellidoMaterno.setText(ucFirst(editApellidoMaterno.getText()));
				editMasculino.requestFocus();
			}
		}

		if(e.getSource() == editMasculino && bandera == true) {
			dateChooser.requestFocus();
		}

		if(e.getSource() == dateChooser) {
			Date fechaNacimiento = dateChooser.getDatoFecha();
			String fecha = String.valueOf(fechaNacimiento);
			if(fecha.isEmpty())
				JOptionPane.showMessageDialog(null, "Escoge una fecha", null, JOptionPane.ERROR_MESSAGE);
			else {
				editTelefono.requestFocus();
			}
		}

		if(e.getSource() == editTelefono) {
			if(editTelefono.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo \"N\u00famero de tel\u00e9fono\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else
				editEMail.requestFocus();

		}

		if(e.getSource() == editEMail) {
			if(editEMail.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo \"E-Mail\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else
				editNoCasa.requestFocus();
		}

		if(e.getSource() == editNoCasa) {
			if(editNoCasa.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo \"NO. Casa\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else
				editCalle.requestFocus();
		}

		if(e.getSource() == editCalle) {
			if(editCalle.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo \"Calle\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else {
				editCalle.setText(ucFirst(editCalle.getText()));
				buscar.requestFocus();
			}
		}

		if(e.getSource() == buscar) {
			datosCodigo = new VistaLista();
			btnGuardar = datosCodigo.getBotonGuardar();
			btnGuardar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(datosCodigo.getCodigoPostal().isEmpty()) 
						JOptionPane.showMessageDialog(null, "No ha selecionado ning\u00fan C\u00f3digo Postal.");
					else if(datosCodigo.getColonia().isEmpty())
						JOptionPane.showMessageDialog(null, "No ha selecionado ninguna Colonia.");
					else if(datosCodigo.getCiudad().isEmpty())
						JOptionPane.showMessageDialog(null, "No ha selecionado ninguna Ciudad.");
					else if(datosCodigo.getEstado().isEmpty())
						JOptionPane.showMessageDialog(null, "No ha selecionado ning\u00fan Estado.");
					else {
						editColonia.setText(datosCodigo.getColonia());
						editCiudad.setText(datosCodigo.getCiudad());
						editEstado.setText(datosCodigo.getEstado());
						codPostal = datosCodigo.getCodigoPostal();
						datosCodigo.limpiarVentana();
						editCarrera.requestFocus();
					}
				}
			});

			btnCancelar = datosCodigo.getBotonCancelar();
			btnCancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					datosCodigo.limpiarVentana();
				}
			});
			datosCodigo.setLocationRelativeTo(null);
			datosCodigo.setVisible(true);
		}

		if(e.getSource() == editCarrera) {
			editSemestre.requestFocus();
		}

		if(e.getSource() == editSemestre) {
			if(editSemestre.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				botonGuardar.requestFocus();
		}
	}

	public boolean hayCamposVacios() {
		Date fechaNacimiento = dateChooser.getDatoFecha();
		String fecha = String.valueOf(fechaNacimiento);
		return editNoControl.getText().isEmpty() || editNombre.getText().isEmpty() || editApellidoPaterno.getText().isEmpty()
				|| editApellidoMaterno.getText().isEmpty() || editTelefono.getText().isEmpty() || editEMail.getText().isEmpty()
				|| editNoCasa.getText().isEmpty() || editCalle.getText().isEmpty() || editColonia.getText().isEmpty() || codPostal.isEmpty() || editCiudad.getText().isEmpty() 
				|| editEstado.getText().isEmpty() || fecha.isEmpty() || editSemestre.getText().isEmpty();
	}

	public Alumno registrarAlumno() {
		Alumno alumno = new Alumno();
		alumno.setControlNumber(editNoControl.getText());
		alumno.setName(editNombre.getText());
		alumno.setPaternal(editApellidoPaterno.getText());
		alumno.setMaternal(editApellidoMaterno.getText());

		if(editMasculino.isSelected())
			alumno.setSex("Masculino");
		else
			alumno.setSex("Femenino");

		String formatoFecha = "dd MMMM yyyy";
		Date fecha = dateChooser.getDatoFecha();
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);

		alumno.setFechaNacimiento(formateador.format(fecha));
		alumno.setTelefono(editTelefono.getText());
		alumno.setEmail(editEMail.getText());
		alumno.setCarrera((String) editCarrera.getSelectedItem());
		alumno.setSemestre(editSemestre.getText());

		Domicilio domicilio = new Domicilio();
		domicilio.setCodigoPostal(codPostal);
		domicilio.setCalle(editCalle.getText());
		domicilio.setNumeroCasa(editNoCasa.getText());
		domicilio.setColonia(editColonia.getText());
		domicilio.setCalle(editCalle.getText());
		domicilio.setCiudad(editCiudad.getText());
		domicilio.setEstado(editEstado.getText());

		alumno.setAddress(domicilio);
		return alumno;
	}

	public void limpiarCampos() {
		editNoControl.setText(null);
		editNombre.setText(null);
		editApellidoPaterno.setText(null);
		editApellidoMaterno.setText(null);
		editTelefono.setText(null);
		editEMail.setText(null);
		editNoCasa.setText(null);
		editCalle.setText(null);
		editColonia.setText(null);
		codPostal = "";
		editCarrera.setSelectedIndex(0);
		editSemestre.setText(null);
		editCiudad.setText(null);
		editEstado.setText(null);
		editNoControl.requestFocus();
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public boolean noControl() {
		return editNoControl.getText().isEmpty() || editNoControl.getText().length() != 8;
	}

	public JTextField getEditNoControl() {
		return editNoControl;
	}

	public String getControlNumber() {
		return editNoControl.getText();
	}

	public void limpiarNoControl() {
		editNoControl.setText(null);
	}

	public void enforcarNombre() {
		editNombre.requestFocus();
	}

	private static String ucFirst(String str) {
		if (str == null || str.isEmpty()) {
			return str;            
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1); 
		}
	}
	
	private void validarNumeroControl() {
		int n = 0;
		for(int i = 0; i < editNoControl.getText().length(); i++) {
			if(!Character.isDigit(editNoControl.getText().charAt(i))) 
				n++;
		}
		
		if(n != 0) {
			JOptionPane.showMessageDialog(null, "No se pueden ingresar letras.", null, JOptionPane.ERROR_MESSAGE);
			String cadena = editNoControl.getText();
			String nCadena = cadena.substring(0, cadena.length() - 1);
			editNoControl.setText(nCadena);
		}
		
		if(editNoControl.getText().length() == 8) {
			editNombre.requestFocus();
		}
	}
}