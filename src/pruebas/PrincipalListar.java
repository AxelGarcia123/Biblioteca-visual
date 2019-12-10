package pruebas;

import java.util.List;

import modelo.BaseDatos;
import modelo.Libro;
import modelo.TablaLibro;

public class PrincipalListar {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");
		
		if (baseDatos.hacerConexion().equals("exito")) {
			TablaLibro tablaLibro = new TablaLibro(baseDatos.getConexion());
			List<Libro> libros = tablaLibro.getLibros();
			System.out.println(libros);
		}
	}
}