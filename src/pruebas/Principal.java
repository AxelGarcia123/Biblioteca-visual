package pruebas;

import modelo.BaseDatos;
import modelo.Libro;
import modelo.TablaLibro;

public class Principal {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		if (baseDatos.hacerConexion().equals("exito")) {
			TablaLibro tablaLibro = new TablaLibro(baseDatos.getConexion());
			Libro libro = new Libro("1", "1", "1", "1", "1", "1", "1", "1");
			tablaLibro.guardar(libro);
			System.out.println("Libro guardado");
		}
		
		else 
			System.out.println("error de coneccion");
	}
}