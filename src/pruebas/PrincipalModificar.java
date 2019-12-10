package pruebas;

import modelo.BaseDatos;
import modelo.Libro;
import modelo.TablaLibro;

public class PrincipalModificar {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");
		System.out.println("AAAAA");

		if (baseDatos.hacerConexion().equals("exito")) {
			System.out.println("AAAAA");
			TablaLibro tablaLibro = new TablaLibro(baseDatos.getConexion());
			System.out.println(tablaLibro.modificar(new Libro("1", "hola", "como", "estan", "todos", "2", "mios", "aaaa")));
		}
	}
}