package modelo;

public class Libro implements Comparable<Libro>{
	private String isbn;
	private String title;
	private String author;
	private String editorial;
	private String numeroEdition;
	private String anioEdicion;
	private String idioma;
	private String paisDeOrigen;
	
	public Libro(){
		
	}
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}

	public Libro(String isbn, String title, String author, String editorial, String numeroEdition, String anioEdicion,
			String idioma, String paisDeOrigen) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.numeroEdition = numeroEdition;
		this.anioEdicion = anioEdicion;
		this.idioma = idioma;
		this.paisDeOrigen = paisDeOrigen;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getNumeroEdition() {
		return numeroEdition;
	}
	public void setNumeroEdition(String numeroEdition) {
		this.numeroEdition = numeroEdition;
	}
	public String getAnioEdicion() {
		return anioEdicion;
	}
	public void setAnioEdicion(String anioEdicion) {
		this.anioEdicion = anioEdicion;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}
	
	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}
	
	@Override
	public String toString() {
		String salida = "";
		salida += "Isbn: "+ isbn + "\n";
		salida += "Título: "+ title + "\n";
		salida += "Autor: "+ author + "\n";
		salida += "Editorial: "+ editorial + "\n";
		salida += "NO. Edición: "+ numeroEdition + "\n";
		salida += "Año de Edición: "+ anioEdicion + "\n";
		salida += "Idioma: "+ idioma + "\n";
		salida += "País de Origen: "+ paisDeOrigen + "\n";
		return salida;
	}
	
	@Override
	public boolean equals(Object o) {
		Libro libro = (Libro) o;
		return isbn.equals(libro.getIsbn());
	}
	
	@Override
	public int compareTo(Libro libro) {
		return isbn.compareTo(libro.isbn);
	}
}