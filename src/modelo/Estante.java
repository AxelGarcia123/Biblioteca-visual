package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estante {
	private List<Libro> estante;
	
	public Estante() {
		 estante = new ArrayList<>();
	}

	public void agregar(Libro libro) {
		estante.add(libro);
	}
	
	public boolean existe(String isbn) {
		return estante.contains(new Libro(isbn));
	}
	
	public Libro getLibro(String isbn) {
		return estante.get(estante.indexOf(new Libro(isbn)));
	}
	
	public void eliminar(String isbn) {
		estante.remove(estante.indexOf(new Libro(isbn)));
	}
	
	public List<Libro> getEstante() {
		return estante;
	}
	
	public boolean estaVacio() {
		return estante.isEmpty();
	}
	
	public String mostrarLibros() {
		return estante.toString();
	}
	
	public void ordenar() {
		Collections.sort(estante);
	}
}
