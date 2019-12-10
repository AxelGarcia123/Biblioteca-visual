package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaDevolucion {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaDevolucion(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			e.toString();
		} 
	}
	
	public String guardar(Devolucion devolucion) {
		String sql = "insert into devolucion (fechaprestamo, fechaentrega, titulo, controlnumber, isbn) values('"+ devolucion.getFechaPrestamo() + 
				"','" + devolucion.getFechaEntrega() + "','" + devolucion.getTitle() + "','" + devolucion.getcontrolNumber() + 
				"','" + devolucion.getIsbn() + "')";
		try {
			statement.executeUpdate(sql);
			return "Libro registrado con exito";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public boolean estaVacia() {
		String sql = "select count(*) from devolucion";
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
		String sql = "select * from devolucion where controlnumber='"+ controlNumber + "'";
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
		String sql = "select * from devolucion where isbn='"+ isbn + "'";
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

	public List<Devolucion> getDevoluciones(){
		String sql = "select * from devolucion";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Devolucion> devoluciones = new ArrayList<>();
			while (rs.next()) {
				Devolucion devolucion = new Devolucion();
				
				devolucion.setControlNumber(rs.getString("controlnumber"));
				devolucion.setIsbn(rs.getString("isbn"));
				devolucion.setTitle(rs.getString("titulo"));
				devolucion.setFechaPrestamo(rs.getString("fechaprestamo"));
				devolucion.setFechaEntrega(rs.getString("fechaentrega"));
				
				devoluciones.add(devolucion);
			}
			return devoluciones;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String eliminar(String controlNumber) {
		String sql = "delete from devolucion where controlnumber ='"+ controlNumber + "'";
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