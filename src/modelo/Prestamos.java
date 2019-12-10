package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prestamos {
private List<Prestamo> prestamos;
	
	public Prestamos() {
		prestamos = new ArrayList<>();
	}

	public void agregar(Prestamo prestamo) {
		prestamos.add(prestamo);
	}
	
	public boolean existe(String isbn) {
		return prestamos.contains(new Prestamo(isbn));
	}
	
	public Prestamo getPrestamo(String isbn) {
		return prestamos.get(prestamos.indexOf(new Prestamo(isbn)));
	}
	
	public void eliminar(String isbn) {
		prestamos.remove(prestamos.indexOf(new Prestamo(isbn)));
	}
	
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}
	
	public boolean estaVacio() {
		return prestamos.isEmpty();
	}
	
	public String mostrarPrestamos() {
		return prestamos.toString();
	}
	
	public void ordenar() {
		Collections.sort(prestamos);
	}
}