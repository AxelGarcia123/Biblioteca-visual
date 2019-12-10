package pruebas;

import modelo.BaseDatos;
import modelo.TablaLibro;

public class PrincipalEliminar {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");
		
		if (baseDatos.hacerConexion().equals("exito")) {
			TablaLibro tablaLibro = new TablaLibro(baseDatos.getConexion());
			tablaLibro.eliminar("1");
			System.out.println("Libro eliminado");
		}
	}
}