package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaPrestamo {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaPrestamo(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			e.toString();
		} 
	}
	
	public String guardar(Prestamo prestamo) {
		String sql = "insert into prestamo (fechaprestamo, fechaentrega, titulo, controlnumber, isbn) values('"+ prestamo.getFechaPrestamo() + 
				"','" + prestamo.getFechaEntrega() + "','" + prestamo.getTitle() + "','" + prestamo.getcontrolNumber() + 
				"','" + prestamo.getIsbn() + "')";
		try {
			statement.executeUpdate(sql);
			return "Libro registrado con exito";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public boolean estaVacia() {
		String sql = "select count(*) from prestamo";
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

	public boolean existeNumeroControl(String controlNumber) {
		String sql = "select * from prestamo where controlnumber='"+ controlNumber + "'";
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
	
	public boolean existeIsbn(String isbn) {
		String sql = "select * from prestamo where isbn='"+ isbn + "'";
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
	
	public Prestamo getPrestamo(String isbn){
		String sql = "select * from prestamo where isbn='"+ isbn + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				Prestamo prestamo = new Prestamo();
				
				prestamo.setControlNumber(rs.getString("controlnumber"));
				prestamo.setIsbn(rs.getString("isbn"));
				prestamo.setTitle(rs.getString("titulo"));
				prestamo.setFechaPrestamo(rs.getString("fechaprestamo"));
				prestamo.setFechaEntrega(rs.getString("fechaentrega"));
				return prestamo;
			}
			else
				return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<Prestamo> getPrestamos(){
		String sql = "select * from prestamo";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Prestamo> prestamos = new ArrayList<>();
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				
				prestamo.setControlNumber(rs.getString("controlnumber"));
				prestamo.setIsbn(rs.getString("isbn"));
				prestamo.setTitle(rs.getString("titulo"));
				prestamo.setFechaPrestamo(rs.getString("fechaprestamo"));
				prestamo.setFechaEntrega(rs.getString("fechaentrega"));
				
				prestamos.add(prestamo);
			}
			return prestamos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String eliminar(String isbn) {
		String sql = "delete from prestamo where isbn='"+ isbn + "'";
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
}