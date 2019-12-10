package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grupo {
	private List<Alumno> grupo;

	public Grupo() {
		grupo = new ArrayList<>();
	}

	public void agregarAlumno(Alumno alumno) {
		grupo.add(alumno);
	}

	public boolean existe(String noControl) {
		return grupo.contains(new Alumno(noControl));
	}
	
	public Alumno getAlumno(String noControl) {
		return grupo.get(grupo.indexOf(new Alumno(noControl)));
	}
	
	public void eliminar(String noControl) {
		grupo.remove(grupo.indexOf(new Alumno(noControl)));
	}

	public boolean estaVacio() {
		return grupo.isEmpty();
	}

	public String mostrarAlumnos() {
		return grupo.toString();
	}
	
	public List<Alumno> getGrupo() {
		return grupo;
	}
	
	public int getTamanio() {
		return grupo.size();
	}
	
	public void ordenar() {
		Collections.sort(grupo);
	}
}