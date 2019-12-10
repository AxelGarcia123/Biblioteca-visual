package modelo;

public class Prestamo implements Comparable<Prestamo>, Disponible{
	
	private String controlNumber;
	private String fechaPrestamo;
	private String fechaEntrega;
	private String isbn;
	private String title;
	
	public Prestamo() {
		
	}
	
	public Prestamo(String dato) {
		if(dato.length() == 8)
			controlNumber = dato;
		else
			isbn = dato;
	}

	@Override
	public String getcontrolNumber() {
		return controlNumber;
	}

	@Override
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	@Override
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	@Override
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@Override
	public String getFechaEntrega() {
		return fechaEntrega;
	}

	@Override
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String getIsbn() {
		return isbn;
	}

	@Override
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		Prestamo prestamo = (Prestamo) o;
		if(isbn == null) {
			return controlNumber.equals(prestamo.getcontrolNumber());
		}
		else
			return isbn.equals(prestamo.getIsbn());
	}
	
	@Override
	public int compareTo(Prestamo prestamo) {
		return isbn.compareTo(prestamo.isbn);
	}

	@Override
	public String toString() {
		String salida = "";
		salida += "NO. Control: "+ controlNumber + "\n";
		salida += "Isbn: "+ isbn + "\n";
		salida += "T\u00edtulo: "+ title + "\n";
		salida += "Fecha de Pr\u00e9stamo: "+ fechaPrestamo + "\n";
		salida += "Fecha de Entrega: "+ fechaEntrega + "\n";
		return salida;
	}
}