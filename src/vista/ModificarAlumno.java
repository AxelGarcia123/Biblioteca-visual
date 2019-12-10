package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import codigospostales.VistaLista;
import modelo.Alumno;
import modelo.Domicilio;
import modelo.Grupo;

import javax.swing.JRadioButton;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class ModificarAlumno extends JPanel implements ActionListener{

	private JLabel lblModificar;
	private JLabel lblControlDeAlumnos;
	private JLabel lblTecnolgicoNacionalDe;
	private JButton botonModificar;
	private JButton botonCancelar;
	private JTextField editNombre;
	private JTextField editPaterno;
	private JTextField editMaterno;
	private JTextField editTelefono;
	private JTextField editEmail;
	private JTextField editNoCasa;
	private JTextField editCalle;
	private JTextField editColonia;
	private JTextField editCiudad;
	private JTextField editEstado;
	private JTextField editSemestre;
	private JButton botonBuscar;
	private JTextField editBuscar;
	private JComboBox editCarrera;
	private RSDateChooser editFechaNacimiento;
	private JLabel editNoControl;
	private String codPostal = "";
	private VistaLista datosCodigo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton botonCodigoPostal;
	private JRadioButton editFemenino;
	private JRadioButton editMasculino;

	public ModificarAlumno() {
		setLayout(new BorderLayout(0, 5));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 112, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		botonModificar = new JButton("Modificar");
		botonModificar.addActionListener(this);
		botonModificar.setForeground(Color.WHITE);
		botonModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonModificar.setBackground(new Color(0, 112, 192));
		panel_1.add(botonModificar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(this);
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCancelar.setBackground(new Color(0, 112, 192));
		panel_1.add(botonCancelar);

		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 4, 3, 20));

		JLabel lblBuscarAlumno = new JLabel("Buscar Alumno:");
		lblBuscarAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblBuscarAlumno);

		editBuscar = new JTextField();
		editBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		editBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editBuscar.setBorder(new LineBorder(new Color(0, 112, 192)));
		editBuscar.addActionListener(this);
		panel_2.add(editBuscar);
		editBuscar.setColumns(10);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonBuscar.setBackground(new Color(0, 112, 192));
		panel_2.add(botonBuscar);

		JLabel label_17 = new JLabel("");
		panel_2.add(label_17);

		JLabel label = new JLabel("NO.Control:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label);
		
		editNoControl = new JLabel("");
		editNoControl.setHorizontalAlignment(SwingConstants.CENTER);
		editNoControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(editNoControl);

		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_1);

		editNombre = new JTextField();
		editNombre.setHorizontalAlignment(SwingConstants.CENTER);
		editNombre.addActionListener(this);
		editNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editNombre.setColumns(10);
		editNombre.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editNombre);

		JLabel label_2 = new JLabel("Apellido Paterno:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_2);

		editPaterno = new JTextField();
		editPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		editPaterno.addActionListener(this);
		editPaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editPaterno.setColumns(10);
		editPaterno.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editPaterno);

		JLabel label_3 = new JLabel("Apellido Materno");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_3);

		editMaterno = new JTextField();
		editMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		editMaterno.addActionListener(this);
		editMaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editMaterno.setColumns(10);
		editMaterno.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editMaterno);

		JLabel label_4 = new JLabel("G\u00E9nero:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_4);
		
		ButtonGroup grupo = new ButtonGroup();

		editMasculino = new JRadioButton("Masculino");
		editMasculino.addActionListener(this);
		editMasculino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(editMasculino);
		grupo.add(editMasculino);

		JLabel label_5 = new JLabel("");
		panel_2.add(label_5);

		editFemenino = new JRadioButton("Femenino");
		editFemenino.addActionListener(this);
		editFemenino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(editFemenino);
		grupo.add(editFemenino);

		JLabel label_6 = new JLabel("Fecha de Nacimiento:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_6);

		editFechaNacimiento = new RSDateChooser();
		editFechaNacimiento.setFuente(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(editFechaNacimiento);

		JLabel label_7 = new JLabel("Tel\u00E9fono:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_7);

		editTelefono = new JTextField();
		editTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		editTelefono.addActionListener(this);
		editTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editTelefono.setColumns(10);
		editTelefono.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editTelefono);

		JLabel label_8 = new JLabel("E-Mail:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_8);

		editEmail = new JTextField();
		editEmail.setHorizontalAlignment(SwingConstants.CENTER);
		editEmail.addActionListener(this);
		editEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editEmail.setColumns(10);
		editEmail.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editEmail);

		JLabel label_9 = new JLabel("No. Casa:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_9);

		editNoCasa = new JTextField();
		editNoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		editNoCasa.addActionListener(this);
		editNoCasa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editNoCasa.setColumns(10);
		editNoCasa.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editNoCasa);

		JLabel label_10 = new JLabel("Calle:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_10);

		editCalle = new JTextField();
		editCalle.setHorizontalAlignment(SwingConstants.CENTER);
		editCalle.addActionListener(this);
		editCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editCalle.setColumns(10);
		editCalle.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editCalle);

		JLabel label_11 = new JLabel("C\u00F3digo Postal:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_11);

		botonCodigoPostal = new JButton("Buscar");
		botonCodigoPostal.setForeground(Color.WHITE);
		botonCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCodigoPostal.addActionListener(this);
		botonCodigoPostal.setBackground(new Color(0, 112, 192));
		panel_2.add(botonCodigoPostal);

		JLabel label_12 = new JLabel("Colonia:");
		label_12.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_12);

		editColonia = new JTextField();
		editColonia.setHorizontalAlignment(SwingConstants.CENTER);
		editColonia.addActionListener(this);
		editColonia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editColonia.setColumns(10);
		editColonia.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editColonia);

		JLabel label_13 = new JLabel("Ciudad:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_13);

		editCiudad = new JTextField();
		editCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		editCiudad.addActionListener(this);
		editCiudad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editCiudad.setColumns(10);
		editCiudad.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editCiudad);

		JLabel label_14 = new JLabel("Estado:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_14);

		editEstado = new JTextField();
		editEstado.setHorizontalAlignment(SwingConstants.CENTER);
		editEstado.addActionListener(this);
		editEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editEstado.setColumns(10);
		editEstado.setBorder(new LineBorder(new Color(0, 112, 192)));
		panel_2.add(editEstado);

		JLabel label_15 = new JLabel("Carrera:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_15);

		editCarrera = new JComboBox();
		editCarrera.addActionListener(this);
		editCarrera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(editCarrera);

		JLabel label_16 = new JLabel("Semestre:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_16);

		editSemestre = new JTextField();
		editSemestre.setHorizontalAlignment(SwingConstants.CENTER);
		editSemestre.addActionListener(this);
		editSemestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSemestre.setBorder(new LineBorder(new Color(0, 112, 192)));
		editSemestre.setColumns(10);
		panel_2.add(editSemestre);

		lblTecnolgicoNacionalDe = new JLabel("Tecnol\u00F3gico Nacional de M\u00E9xico");
		lblTecnolgicoNacionalDe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTecnolgicoNacionalDe.setForeground(Color.WHITE);
		lblTecnolgicoNacionalDe.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTecnolgicoNacionalDe);

		lblModificar = new JLabel("Modificar Alumno");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblModificar.setForeground(Color.WHITE);
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblModificar);

	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		boolean bandera = true;
		if(e.getSource() == editBuscar) {
			if(editBuscar.getText().isEmpty() || editBuscar.getText().length() != 8)
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio o tener menos de 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
			else
				botonBuscar.requestFocus();
		}
		
		if(e.getSource() == editNombre) {
			if(editNombre.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo \"Nombre\" no puede quedar vacio", null, JOptionPane.ERROR_MESSAGE);
			else if(!editNombre.getText().isEmpty() && editNombre.getText().charAt(editNombre.getText().length() - 1) == 'o') {
				bandera = false;
				editMasculino.setSelected(true);
				editPaterno.requestFocus();
			}
			else if(!editNombre.getText().isEmpty() && editNombre.getText().charAt(editNombre.getText().length() - 1) == 'a') {
				editNombre.setText(ucFirst(editNombre.getText()));
				bandera = false;
				editFemenino.setSelected(true);
				editPaterno.requestFocus();
			}
			else {
				editNombre.setText(ucFirst(editNombre.getText()));
				editPaterno.requestFocus();
			}
		}
		
		if(e.getSource() == editPaterno) {
			if(editPaterno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				editPaterno.setText(ucFirst(editPaterno.getText()));
				editMaterno.requestFocus();
			}
		}
		
		if(e.getSource() == editMaterno) {
			if(editMaterno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				editMaterno.setText(ucFirst(editMaterno.getText()));
				editMasculino.requestFocus();
			}
		}
		
		if(e.getSource() == editMasculino && bandera == true) {
			editFechaNacimiento.requestFocus();
		}
		
		if(e.getSource() == editFechaNacimiento) {
			Date fechaNacimiento = editFechaNacimiento.getDatoFecha();
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
				editEmail.requestFocus();
				
		}
		
		if(e.getSource() == editEmail) {
			if(editEmail.getText().isEmpty()) 
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
				botonCodigoPostal.requestFocus();
			}
		}
		
		if(e.getSource() == botonCodigoPostal) {
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
				botonModificar.requestFocus();
		}
	}

	public void mostrarDatos(Alumno alumno) {
		editNoControl.setText(alumno.getControlNumber());
		editNombre.setText(alumno.getName());
		editPaterno.setText(alumno.getPaternal());
		editMaterno.setText(alumno.getMaternal());
		
		if(alumno.getSex().equals("Masculino"))
			editMasculino.setSelected(true);
		else
			editFemenino.setSelected(true);
		
		String fecha = alumno.getFechaNacimiento();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse("22/09/2016");
        } 
        catch (ParseException ex) {
            System.out.println(ex);
        }
		
		editFechaNacimiento.setDatoFecha(fechaDate);
		editFechaNacimiento.setForeground(new Color(153, 0, 0));
		editTelefono.setText(alumno.getTelefono());
		editEmail.setText(alumno.getEmail());
		editNoCasa.setText(alumno.getAddress().getNumeroCasa());
		editCalle.setText(alumno.getAddress().getCalle());
		codPostal = alumno.getAddress().getCodigoPostal();
		editColonia.setText(alumno.getAddress().getColonia());
		editCiudad.setText(alumno.getAddress().getCiudad());
		editEstado.setText(alumno.getAddress().getEstado());
		editCarrera.setModel(new DefaultComboBoxModel(new String[] {"Arquitectura", "Contador P\u00FAblico", "Gesti\u00F3n Empresarial", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Electromec\u00E1nica", "Ingenier\u00EDa en Industrias Alimentarias", "Ingenier\u00EDa en Innovaci\u00F3n Agr\u00EDcola Sustentable", "Ingenier\u00EDa en Sistemas Computacionales", "Ingenier\u00EDa Industrial", "Licenciatura en Administraci\u00F3n"}));
		editCarrera.setSelectedItem(alumno.getCarrera());
		editSemestre.setText(alumno.getSemestre());
		editBuscar.setText(null);
		editNombre.requestFocus();
	}
	
	public Alumno modificarAlumno() {
		Alumno alumno = new Alumno();
		alumno.setControlNumber(editNoControl.getText());
		alumno.setName(editNombre.getText());
		alumno.setPaternal(editPaterno.getText());
		alumno.setMaternal(editMaterno.getText());
		
		if(editMasculino.isSelected())
			alumno.setSex("Masculino");
		else
			alumno.setSex("Femenino");
		
		
		String formatoFecha = "dd MMMM yyyy";
		Date fecha = editFechaNacimiento.getDatoFecha();
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
		
		alumno.setFechaNacimiento(formateador.format(fecha));
		alumno.setTelefono(editTelefono.getText());
		alumno.setEmail(editEmail.getText());
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
	
	public boolean hayCamposVacios() {
		Date fechaNacimiento = editFechaNacimiento.getDatoFecha();
		String fecha = String.valueOf(fechaNacimiento);
		return editNoControl.getText().isEmpty() || editNombre.getText().isEmpty() || editPaterno.getText().isEmpty()
		|| editMaterno.getText().isEmpty() || editTelefono.getText().isEmpty() || editEmail.getText().isEmpty()
		|| editNoCasa.getText().isEmpty() || editCalle.getText().isEmpty() || editColonia.getText().isEmpty() || codPostal.isEmpty() || editCiudad.getText().isEmpty() 
		|| editEstado.getText().isEmpty() /*|| fecha.isEmpty()*/ || editSemestre.getText().isEmpty();
	}
	
	public void limpiarCampos() {
		editNoControl.setText(null);
		editNombre.setText(null);
		editPaterno.setText(null);
		editMaterno.setText(null);
		editTelefono.setText(null);
		editEmail.setText(null);
		editNoCasa.setText(null);
		editCalle.setText(null);
		editColonia.setText(null);
		codPostal = "";
		editCarrera.setModel(new DefaultComboBoxModel());
		editSemestre.setText(null);
		editCiudad.setText(null);
		editEstado.setText(null);
		editBuscar.requestFocus();
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}
	
	public String getNoControl() {
		return editNoControl.getText();
	}
	
	public JButton getBotonModificar() {
		return botonModificar;
	}
	
	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public boolean campoVacio() {
		return editBuscar.getText().isEmpty();
	}

	public boolean longitudCampo() {
		return editBuscar.getText().length() == 8;
	}

	public String campoBuscar() {
		return editBuscar.getText();
	}
	
	public void enfocarCursor() {
		editBuscar.requestFocus();
		editBuscar.setText(null);
	}
	
	private static String ucFirst(String str) {
		if (str == null || str.isEmpty()) {
			return str;            
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1); 
		}
	}
}