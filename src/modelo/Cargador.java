package modelo;

public class Cargador {
	public Alumno cargarAlumno(String line) {
		String[] aux = line.split(",");
		Domicilio domicilio = new Domicilio(aux[0], aux[1], aux[2], aux[3], aux[4], aux[5]);
		Alumno alumno = new Alumno(aux[6], aux[7], aux[8], aux[9], aux[10], aux[11], aux[12], aux[13], aux[14], aux[15], domicilio);
		return alumno;
	}
	
	public Libro cargarLibros(String line) {
		String aux[] = line.split(",");
		Libro libro = new Libro(aux[0], aux[1], aux[2], aux[3], aux[4], aux[5], aux[6], aux[7]);
		return libro;
	}
}