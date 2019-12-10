package pruebas;

import modelo.Alumno;
import modelo.BaseDatos;
import modelo.Domicilio;
import modelo.TablaAlumno;

public class PrincipalAlumno {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		if (baseDatos.hacerConexion().equals("exito")) {
			TablaAlumno tablaAlumno = new TablaAlumno(baseDatos.getConexion());
			Domicilio domicilio = new Domicilio("2", "2", "2", "2", "2", "2");
			Alumno alumno = new Alumno("3", "1", "1", "1", "1", "1", "1", "1", "1", "1", domicilio);
			tablaAlumno.guardar(alumno);
			System.out.println("Alumno guardado");
		}
		
		else 
			System.out.println("error de coneccion");
	}
}