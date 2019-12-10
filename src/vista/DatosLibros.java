package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import modelo.Estante;
import modelo.Libro;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

@SuppressWarnings("serial")
public class DatosLibros extends JPanel implements ActionListener{
	private JPanel panelTitulo;
	private JPanel panelBotones;
	private JPanel panelCapturarLibros;
	private JLabel tituloPrincipal;
	private JLabel tituloSecundario;
	private JButton botonGuardar;
	private JButton botonCancelar;
	private JTextField cajaIsbn;
	private JTextField cajaTitulo;
	private JTextField cajaAutor;
	private JTextField cajaEditorial;
	private JTextField cajaAnioEdicion;
	private JTextField cajaIdioma;
	private JTextField cajaPaisOrigen;
	private JComboBox cBEdicion;
	//private Estante estante;

	public DatosLibros() {
		setLayout(new BorderLayout(0, 25));
		//estante = new Estante();

		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 112, 192));
		panelTitulo.setForeground(new Color(0, 0, 0));
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(2, 1, 0, 0));

		tituloPrincipal = new JLabel("Biblioteca central del TecNM");
		tituloPrincipal.setForeground(Color.WHITE);
		tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPrincipal.setFont(new Font("Roboto", Font.PLAIN, 30));
		panelTitulo.add(tituloPrincipal);

		tituloSecundario = new JLabel("Captura de datos de libros");
		tituloSecundario.setForeground(Color.WHITE);
		tituloSecundario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloSecundario.setFont(new Font("Roboto", Font.PLAIN, 30));
		panelTitulo.add(tituloSecundario);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(240, 240, 240));
		add(panelBotones, BorderLayout.SOUTH);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setForeground(Color.WHITE);
		botonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonGuardar.setBackground(new Color(0, 112, 192));
		panelBotones.add(botonGuardar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCancelar.setBackground(new Color(0, 112, 192));
		panelBotones.add(botonCancelar);

		panelCapturarLibros = new JPanel();
		panelCapturarLibros.setBackground(new Color(240, 240, 240));
		add(panelCapturarLibros, BorderLayout.CENTER);
		panelCapturarLibros.setLayout(new GridLayout(4, 4, 0, 100));

		JLabel lblNewLabel = new JLabel("ISBN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel);

		cajaIsbn = new JTextField();
		cajaIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		cajaIsbn.addActionListener(this);
		cajaIsbn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaIsbn.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaIsbn);
		cajaIsbn.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_1);

		cajaTitulo = new JTextField();
		cajaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		cajaTitulo.addActionListener(this);
		cajaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaTitulo.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaTitulo);
		cajaTitulo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Autor:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_2);

		cajaAutor = new JTextField();
		cajaAutor.setHorizontalAlignment(SwingConstants.CENTER);
		cajaAutor.addActionListener(this);
		cajaAutor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaAutor.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaAutor);
		cajaAutor.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Editorial:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_3);

		cajaEditorial = new JTextField();
		cajaEditorial.setHorizontalAlignment(SwingConstants.CENTER);
		cajaEditorial.addActionListener(this);
		cajaEditorial.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaEditorial.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaEditorial);
		cajaEditorial.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("NO. de edici\u00F3n:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_4);

		cBEdicion = new JComboBox();
		cBEdicion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cBEdicion.addActionListener(this);
		cBEdicion.setModel(new DefaultComboBoxModel(new String[] {"Primera", "Segunda", "Tercera", "Cuarta", "Quinta", "Sexta", "Septima", "Octava", "Novena ", "D\u00E9cima"}));
		panelCapturarLibros.add(cBEdicion);

		JLabel lblNewLabel_5 = new JLabel("A\u00F1o de edici\u00F3n:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_5);

		cajaAnioEdicion = new JTextField();
		cajaAnioEdicion.setHorizontalAlignment(SwingConstants.CENTER);
		cajaAnioEdicion.addActionListener(this);
		cajaAnioEdicion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaAnioEdicion.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaAnioEdicion);
		cajaAnioEdicion.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Idioma:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_6);

		cajaIdioma = new JTextField();
		cajaIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		cajaIdioma.addActionListener(this);
		cajaIdioma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaIdioma.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaIdioma);
		cajaIdioma.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Pa\u00EDs de origen:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(lblNewLabel_7);

		cajaPaisOrigen = new JTextField();
		cajaPaisOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		cajaPaisOrigen.addActionListener(this);
		cajaPaisOrigen.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cajaPaisOrigen.setBorder(new LineBorder(new Color(0, 112, 192)));
		panelCapturarLibros.add(cajaPaisOrigen);
		cajaPaisOrigen.setColumns(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cajaTitulo) {
			if(cajaTitulo.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				cajaTitulo.setText(ucFirst(cajaTitulo.getText()));
				cajaAutor.requestFocus();
			}
		}
		
		if(e.getSource() == cajaAutor) {
			if(cajaAutor.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				cajaAutor.setText(ucFirst(cajaAutor.getText()));
				cajaEditorial.requestFocus();
			}
		}
		
		if(e.getSource() == cajaEditorial) {
			if(cajaEditorial.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				cajaEditorial.setText(ucFirst(cajaEditorial.getText()));
				cBEdicion.requestFocus();
			}
		}
		
		if(e.getSource() == cBEdicion) {
			cajaAnioEdicion.requestFocus();
		}
		
		if(e.getSource() == cajaAnioEdicion) {
			if(cajaAnioEdicion.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				cajaIdioma.requestFocus();
		}
		
		if(e.getSource() == cajaIdioma) {
			if(cajaIdioma.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				cajaIdioma.setText(ucFirst(cajaIdioma.getText()));
				cajaPaisOrigen.requestFocus();
			}
		}
		
		if(e.getSource() == cajaPaisOrigen) {
			if(cajaPaisOrigen.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else {
				cajaPaisOrigen.setText(ucFirst(cajaPaisOrigen.getText()));
				botonGuardar.requestFocus();
			}
		}
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void fijarFoco() {
		cajaIsbn.requestFocus();
	}
	
	public JTextField getCajaIsbn() {
		return cajaIsbn;
	}
	
	public void enfocarTitulo() {
		cajaTitulo.requestFocus();
	}
	
	public boolean hayCajasVacias() {
		return cajaIsbn.getText().isEmpty() || cajaTitulo.getText().isEmpty()
			   || cajaAutor.getText().isEmpty() || cajaAnioEdicion.getText().isEmpty() 
			   || cajaEditorial.getText().isEmpty() || cajaIdioma.getText().isEmpty()
			   || cajaPaisOrigen.getText().isEmpty() || cajaIsbn.getText().length() != 15;
	}
	
	public Libro getLibro() {
		Libro libro = new Libro();
		libro.setIsbn(cajaIsbn.getText());
		libro.setTitle(cajaTitulo.getText());
		libro.setAuthor(cajaAutor.getText());
		libro.setNumeroEdition((String) cBEdicion.getSelectedItem());
		libro.setAnioEdicion(cajaAnioEdicion.getText());
		libro.setEditorial(cajaEditorial.getText());
		libro.setIdioma(cajaIdioma.getText());
		libro.setPaisDeOrigen(cajaPaisOrigen.getText());
		
		return libro;
	}
	
	public void vaciarCajas() {
		cajaIsbn.setText(null);
		cajaTitulo.setText(null);
		cajaAutor.setText(null);
		cajaAnioEdicion.setText(null); 
		cajaEditorial.setText(null);
		cajaIdioma.setText(null);
		cajaPaisOrigen.setText(null);
		cBEdicion.setSelectedIndex(0);
		cajaIsbn.requestFocus();
	}
	
	private static String ucFirst(String str) {
		if (str == null || str.isEmpty()) {
			return str;            
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1); 
		}
	}
}