package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Devoluciones {
private List<Devolucion> devoluciones;
	
	public Devoluciones() {
		devoluciones = new ArrayList<>();
	}

	public void agregar(Devolucion devolucion) {
		devoluciones.add(devolucion);
	}
	
	public String mostrarDevoluciones() {
		return devoluciones.toString();
	}
	
	public List<Devolucion> getDevoluciones() {
		return devoluciones;
	}
	
	public void ordenar() {
		Collections.sort(devoluciones);
	}
}