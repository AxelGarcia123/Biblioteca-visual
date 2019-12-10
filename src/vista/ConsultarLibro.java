package vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.Libro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarLibro extends JPanel implements ActionListener{
	private JPanel panelTitulo;
	private JPanel panelBotones;
	private JPanel panelCapturarLibros;
	private JLabel tituloPrincipal;
	private JLabel tituloSecundario;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel isbn;
	private JLabel titulo;
	private JLabel autor;
	private JLabel editorial;
	private JLabel noDeEdicion;
	private JLabel anioDeEdicion;
	private JLabel idioma;
	private JLabel paisOrigen;
	private JLabel datoIsbn;
	private JLabel datoTitulo;
	private JLabel datoAutor;
	private JLabel datoEditorial;
	private JLabel datoNoEdicion;
	private JLabel datoAnioEdicion;
	private JLabel datoIdioma;
	private JLabel datoPaisOrigen;
	private JLabel buscarLibro;
	private JTextField editBuscarLibro;
	private JButton botonBuscar;
	private JLabel label;

	public ConsultarLibro() {
		setLayout(new BorderLayout(20, 25));

		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 112, 192));
		panelTitulo.setForeground(new Color(0, 0, 0));
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(2, 1, 0, 0));

		tituloPrincipal = new JLabel("Biblioteca central del TecNM");
		tituloPrincipal.setForeground(Color.WHITE);
		tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTitulo.add(tituloPrincipal);

		tituloSecundario = new JLabel("Consulta de Libros");
		tituloSecundario.setForeground(Color.WHITE);
		tituloSecundario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloSecundario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTitulo.add(tituloSecundario);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(240, 240, 240));
		add(panelBotones, BorderLayout.SOUTH);

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(Color.WHITE);
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonAceptar.setBackground(new Color(0, 112, 192));
		panelBotones.add(botonAceptar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonCancelar.setBackground(new Color(0, 112, 192));
		panelBotones.add(botonCancelar);

		panelCapturarLibros = new JPanel();
		panelCapturarLibros.setBackground(new Color(240, 240, 240));
		add(panelCapturarLibros, BorderLayout.CENTER);
		panelCapturarLibros.setLayout(new GridLayout(5, 4, 20, 70));

		buscarLibro = new JLabel("Buscar Libro:");
		buscarLibro.setHorizontalAlignment(SwingConstants.RIGHT);
		buscarLibro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(buscarLibro);

		editBuscarLibro = new JTextField();
		editBuscarLibro.setHorizontalAlignment(SwingConstants.CENTER);
		editBuscarLibro.addActionListener(this);
		editBuscarLibro.setBorder(new LineBorder(new Color(0, 112, 192)));
		editBuscarLibro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelCapturarLibros.add(editBuscarLibro);
		editBuscarLibro.setColumns(10);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonBuscar.setBackground(new Color(0, 112, 192));
		botonBuscar.setForeground(Color.WHITE);
		panelCapturarLibros.add(botonBuscar);

		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(label);

		isbn = new JLabel("ISBN:");
		isbn.setHorizontalAlignment(SwingConstants.RIGHT);
		isbn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(isbn);

		datoIsbn = new JLabel("");
		datoIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoIsbn);

		titulo = new JLabel("T\u00EDtulo:");
		titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(titulo);

		datoTitulo = new JLabel("");
		datoTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoTitulo);

		autor = new JLabel("Autor:");
		autor.setHorizontalAlignment(SwingConstants.RIGHT);
		autor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(autor);

		datoAutor = new JLabel("");
		datoAutor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoAutor);

		editorial = new JLabel("Editorial:");
		editorial.setHorizontalAlignment(SwingConstants.RIGHT);
		editorial.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(editorial);

		datoEditorial = new JLabel("");
		datoEditorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoEditorial);

		noDeEdicion = new JLabel("NO. de edici\u00F3n:");
		noDeEdicion.setHorizontalAlignment(SwingConstants.RIGHT);
		noDeEdicion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(noDeEdicion);

		datoNoEdicion = new JLabel("");
		datoNoEdicion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoNoEdicion);

		anioDeEdicion = new JLabel("A\u00F1o de edici\u00F3n:");
		anioDeEdicion.setHorizontalAlignment(SwingConstants.RIGHT);
		anioDeEdicion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(anioDeEdicion);

		datoAnioEdicion = new JLabel("");
		datoAnioEdicion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoAnioEdicion);

		idioma = new JLabel("Idioma:");
		idioma.setHorizontalAlignment(SwingConstants.RIGHT);
		idioma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(idioma);

		datoIdioma = new JLabel("");
		datoIdioma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoIdioma);

		paisOrigen = new JLabel("Pa\u00EDs de origen:");
		paisOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		paisOrigen.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCapturarLibros.add(paisOrigen);

		datoPaisOrigen = new JLabel("");
		datoPaisOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCapturarLibros.add(datoPaisOrigen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editBuscarLibro) {
			if(!editBuscarLibro.getText().isEmpty()) {
				if(editBuscarLibro.getText().length() == 15) {
					botonBuscar.requestFocus();
				}
				else
					JOptionPane.showMessageDialog(null, "El \"Isbn\" debe tener 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public JTextField getCampo() {
		return editBuscarLibro;
	}

	public void mostrarDatosLibro(Libro libro) {
		datoIsbn.setText(libro.getIsbn());
		datoTitulo.setText(libro.getTitle());
		datoAutor.setText(libro.getAuthor());
		datoEditorial.setText(libro.getEditorial());
		datoNoEdicion.setText(libro.getNumeroEdition());
		datoAnioEdicion.setText(libro.getAnioEdicion());
		datoIdioma.setText(libro.getIdioma());
		datoPaisOrigen.setText(libro.getPaisDeOrigen());
		editBuscarLibro.setText(null);
		editBuscarLibro.requestFocus();
	}

	public void limpiarCampos() {
		datoIsbn.setText(null);
		datoTitulo.setText(null);
		datoAutor.setText(null);
		datoEditorial.setText(null);
		datoNoEdicion.setText(null);
		datoAnioEdicion.setText(null);
		datoIdioma.setText(null);
		datoPaisOrigen.setText(null);
		editBuscarLibro.setText(null);
		editBuscarLibro.requestFocus();
	}

	public void enfocarCursor() {
		editBuscarLibro.requestFocus();
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}
}