package vista;

import java.awt.EventQueue;
import java.util.List;
import java.util.Stack;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class VentanaCajas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField editNombre;
	private JTextField editPaterno;
	private JLabel nombre;
	private JLabel apellidoPaterno;
	private JTextField editMaterno;
	private JLabel apellidoMaterno;
	private JTextField editNumeroControl;
	private JLabel numeroControl;
	private JLabel sexo;
	private JLabel edad;
	private JComboBox comboBox;
	private JLabel lblEscribeTuCarrera;
	private JRadioButton masculino;
	private JRadioButton femenino;
	private JLabel lblSemestre;
	private JTextField editSemestre;
	private boolean bandera = true;
	private JComboBox carrera;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCajas frame = new VentanaCajas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaCajas() {
		setTitle("Control de Alumnos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCajas.class.getResource("/recursos/tree.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		numeroControl = new JLabel("NO. de control:");
		numeroControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(numeroControl);
		
		editNumeroControl = new JTextField();
		editNumeroControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editNumeroControl.addActionListener(this);
		contentPane.add(editNumeroControl);
		editNumeroControl.setColumns(12);
		
		nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(nombre);
		
		editNombre = new JTextField();
		editNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editNombre.addActionListener(this);
		contentPane.add(editNombre);
		editNombre.setColumns(12);
		
		apellidoPaterno = new JLabel("Ap. Paterno:");
		apellidoPaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(apellidoPaterno);
		
		editPaterno = new JTextField();
		editPaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editPaterno.addActionListener(this);
		contentPane.add(editPaterno);
		editPaterno.setColumns(12);
		
		apellidoMaterno = new JLabel("Ap. Materno:");
		apellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(apellidoMaterno);
		
		editMaterno = new JTextField();
		editMaterno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editMaterno.addActionListener(this);
		contentPane.add(editMaterno);
		editMaterno.setColumns(12);
		
		sexo = new JLabel("Sexo:");
		sexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(sexo);
		
		ButtonGroup group = new ButtonGroup();
		
		masculino = new JRadioButton("Masculino");
		masculino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		masculino.addActionListener(this);
		contentPane.add(masculino);
		group.add(masculino);
		
		femenino = new JRadioButton("Femenino");
		femenino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		femenino.addActionListener(this);
		contentPane.add(femenino);
		group.add(femenino);
		
		edad = new JLabel("Edad:");
		edad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(edad);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		contentPane.add(comboBox);
		
		lblEscribeTuCarrera = new JLabel("Carrera:");
		lblEscribeTuCarrera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEscribeTuCarrera);
		
		carrera = new JComboBox();
		carrera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carrera.addActionListener(this);
		carrera.setModel(new DefaultComboBoxModel(new String[] {"Arquitectura", "Contador P\u00FAblico", "Gesti\u00F3n Empresarial", "Ing. Civil", "Ing. Electromec\u00E1nica", "Ing. en Industrial Alimentarias", "Ing. en Innovaci\u00F3n Agr\u00EDcola Sustentable", "Ing. en Sistemas Computacionales", "Ing. Industrial", "Licenciatura en Administraci\u00F3n"}));
		carrera.setToolTipText("");
		contentPane.add(carrera);
		
		lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSemestre);
		
		editSemestre = new JTextField();
		editSemestre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		editSemestre.addActionListener(this);
		contentPane.add(editSemestre);
		editSemestre.setColumns(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editNumeroControl) {
			if(editNumeroControl.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.\nPor favor, escriba el n\u00famero de control.");
			else if(editNumeroControl.getText().length() != 8)
				JOptionPane.showMessageDialog(null, "Debes ingresar 8 n\u00fameros");
			else
				editNombre.requestFocus();
		}
		
		if(e.getSource() == editNombre) {
			Stack<Character> pila = new Stack<>();
			for(int i = 0; i < editNombre.getText().length(); i++)
				pila.push(editNombre.getText().charAt(i));
			
			if(editNombre.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.\nPor favor, escriba un nombre.");
			else {
				if(pila.peek() == 'o') {
					masculino.setSelected(true);
					bandera = false;
				}
				else if(pila.peek() == 'a') {
					femenino.setSelected(true);
					bandera = false;
				}
				editPaterno.requestFocus();
			}
		}
		
		if(e.getSource() == editPaterno) {
			if(editPaterno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.\nPor favor, escriba su apellido paterno.");
			else
				editMaterno.requestFocus();
		}
		
		if(e.getSource() == editMaterno) {
			if(editMaterno.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.\nPor favor, escriba su apellido materno.");
			else {
				if(bandera == false)
					comboBox.requestFocus();
				else
					masculino.requestFocus();
			}
		}
		
		if(e.getSource() == masculino && bandera == true) {
			comboBox.requestFocus();
		}
		
		if(e.getSource() == comboBox) {
			carrera.requestFocus();
		}
		
		if(e.getSource() == carrera) {
			editSemestre.requestFocus();
		}
	}
}
