package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaLibro {
	private Connection conexion;
	private java.sql.Statement statement;
	
	public TablaLibro(Connection conexion) {
		super();
		this.conexion = conexion;
		
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			e.toString();
		} 
	}
	
	public String guardar(Libro libro) {
		String sql = "insert into libro values('"+ libro.getIsbn() + "','" + libro.getTitle() + "','" + libro.getAuthor() + "','" + 
	libro.getEditorial() + "','" + libro.getNumeroEdition() + "','" + libro.getAnioEdicion() + "','" + libro.getIdioma() + "','" +libro.getPaisDeOrigen() 
	+ "')";
		try {
			statement.executeUpdate(sql);
			return "Libro registrado con exito";
		} catch (SQLException e) {
			return sql.toString();
		}
	}
	
	public boolean existe(String isbn) {
		String sql = "select * from libro where isbn='"+ isbn + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public Libro getLibro(String isbn) {
		String sql = "select * from libro where isbn='"+ isbn + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Libro libro = new Libro();
				libro.setIsbn(rs.getString("isbn"));
				libro.setTitle(rs.getString("titulo"));
				libro.setAuthor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setNumeroEdition(rs.getString("numedicion"));
				libro.setAnioEdicion(rs.getString("anioedicion"));
				libro.setIdioma(rs.getString("idioma"));
				libro.setPaisDeOrigen(rs.getString("paisorigen"));
				return libro;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<Libro> getLibros(){
		String sql = "select * from libro";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Libro> libros = new ArrayList<>();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIsbn(rs.getString("isbn"));
				libro.setTitle(rs.getString("titulo"));
				libro.setAuthor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setNumeroEdition(rs.getString("numedicion"));
				libro.setAnioEdicion(rs.getString("anioedicion"));
				libro.setIdioma(rs.getString("idioma"));
				libro.setPaisDeOrigen(rs.getString("paisorigen"));
				libros.add(libro);
			}
			return libros;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String eliminar(String isbn) {
		String sql = "delete from libro where isbn ='"+ isbn + "'";
		try {
			int n = statement.executeUpdate(sql);
			if (n == 1) {
				return "Exito";
			} else {
				return "Error";
			}
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	public boolean estaVacia() {
		String sql = "select count(*) from libro";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (!rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public String modificar(Libro libro) {
		String sql = "update libro set titulo='"+ libro.getTitle() + "', autor='" + libro.getAuthor() + "', editorial='" + 
	libro.getEditorial() + "'" + ", numedicion='" + libro.getNumeroEdition() + "', anioedicion='" + libro.getAnioEdicion() +
	"', idioma='" + libro.getIdioma() + "', paisorigen='" + libro.getPaisDeOrigen() + "' where isbn='" + libro.getIsbn() + "'";
		try {
			int n = statement.executeUpdate(sql);
			if (n == 1) {
				return "Exito";
			} else {
				return "Error";
			}
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	public List<Libro> getFiltro(String filtro) {
		String sql = "select from * where titulo like '%" + filtro + "%'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Libro> libros = new ArrayList<>();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIsbn(rs.getString("isbn"));
				libro.setTitle(rs.getString("titulo"));
				libro.setAuthor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setNumeroEdition(rs.getString("numedicion"));
				libro.setAnioEdicion(rs.getString("anioedicion"));
				libro.setIdioma(rs.getString("idioma"));
				libro.setPaisDeOrigen(rs.getString("paisorigen"));
				libros.add(libro);
			}
			return libros;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}	
}
