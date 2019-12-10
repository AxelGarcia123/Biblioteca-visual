package pruebas;

import modelo.BaseDatos;
import modelo.Libro;
import modelo.TablaLibro;

public class PrincipalConsultar {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		if (baseDatos.hacerConexion().equals("exito")) {
			TablaLibro tablaLibro = new TablaLibro(baseDatos.getConexion());
			if (tablaLibro.existe("2")) {
				System.out.println("Ya existe");
				Libro libro = tablaLibro.getLibro("1");
				System.out.println(libro.getIsbn());
			} else {
				System.out.println("No existe");
			}
		}
	}
}