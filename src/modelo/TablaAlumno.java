package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaAlumno {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaAlumno(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			e.toString();
		} 
	}

	public String guardar(Alumno alumno) {
		String sql = "insert into alumno values('"+ alumno.getControlNumber() + "','" + alumno.getName() + "','" + alumno.getPaternal() + "','" + 
				alumno.getMaternal() + "','" + alumno.getSex() + "','" + alumno.getFechaNacimiento() + "','" + alumno.getAddress().getNumeroCasa() + 
				"','" + alumno.getAddress().getCalle() + "','"+ alumno.getAddress().getColonia() + "','"+ alumno.getAddress().getCodigoPostal() +
				"','" + alumno.getAddress().getCiudad() + "','" + alumno.getAddress().getEstado() + "','" + alumno.getTelefono() +
				"','" + alumno.getEmail() + "','" + alumno.getCarrera() + "','" + alumno.getSemestre() + "')";
		try {
			statement.executeUpdate(sql);
			return "Libro registrado con exito";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public boolean estaVacia() {
		String sql = "select count(*) from alumno";
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

	public boolean existe(String controlNumber) {
		String sql = "select * from alumno where controlnumber='"+ controlNumber + "'";
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

	public Alumno getAlumno(String noControl) {
		String sql = "select * from alumno where controlnumber='"+ noControl + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setControlNumber(rs.getString("controlnumber"));
				alumno.setName(rs.getString("nombre"));
				alumno.setPaternal(rs.getString("apellidop"));
				alumno.setMaternal(rs.getString("apellidom"));
				alumno.setSex(rs.getString("sexo"));
				alumno.setFechaNacimiento(rs.getString("fechanacimiento"));
				Domicilio domicilio = new Domicilio();
				domicilio.setNumeroCasa(rs.getString("numerocasa"));
				domicilio.setCalle(rs.getString("calle"));
				domicilio.setColonia(rs.getString("colonia"));
				domicilio.setCodigoPostal(rs.getString("codigopostal"));
				domicilio.setCiudad(rs.getString("ciudad"));
				domicilio.setEstado(rs.getString("estado"));
				alumno.setAddress(domicilio);
				alumno.setTelefono(rs.getString("telefono"));
				alumno.setEmail(rs.getString("email"));
				alumno.setCarrera(rs.getString("carrera"));
				alumno.setSemestre(rs.getString("semestre"));
				return alumno;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<Alumno> getAlumnos(){
		String sql = "select * from alumno";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Alumno> alumnos = new ArrayList<>();
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setControlNumber(rs.getString("controlnumber"));
				alumno.setName(rs.getString("nombre"));
				alumno.setPaternal(rs.getString("apellidop"));
				alumno.setMaternal(rs.getString("apellidom"));
				alumno.setSex(rs.getString("sexo"));
				alumno.setFechaNacimiento(rs.getString("fechanacimiento"));
				
				Domicilio domicilio = new Domicilio();
				domicilio.setNumeroCasa(rs.getString("numerocasa"));
				domicilio.setCalle(rs.getString("calle"));
				domicilio.setColonia(rs.getString("colonia"));
				domicilio.setCodigoPostal(rs.getString("codigopostal"));
				domicilio.setCiudad(rs.getString("ciudad"));
				domicilio.setEstado(rs.getString("estado"));
				
				alumno.setAddress(domicilio);
				alumno.setTelefono(rs.getString("telefono"));
				alumno.setEmail(rs.getString("email"));
				alumno.setCarrera(rs.getString("carrera"));
				alumno.setSemestre(rs.getString("semestre"));
				alumnos.add(alumno);
			}
			return alumnos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public String eliminar(String controlNumber) {
		String sql = "delete from alumno where controlnumber='"+ controlNumber + "'";
		try {
			int n = statement.executeUpdate(sql);
			if (n == 1) {
				return "Exito";
			} else {
				return "Error";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
	public String modificar(Alumno alumno) {
		String sql = "update alumno set nombre='" + alumno.getName() + "', apellidop='" + alumno.getPaternal() + "', apellidom='" + 
				alumno.getMaternal() + "', sexo='" + alumno.getSex() + "', fechanacimiento='" + alumno.getFechaNacimiento() + 
				"', numerocasa='" + alumno.getAddress().getNumeroCasa() + "', calle='" + alumno.getAddress().getCalle() + 
				"', colonia='"+ alumno.getAddress().getColonia() + "', codigopostal='"+ alumno.getAddress().getCodigoPostal() +
				"', ciudad='" + alumno.getAddress().getCiudad() + "', estado='" + alumno.getAddress().getEstado() + 
				"', telefono='" + alumno.getTelefono() + "', email='" + alumno.getEmail() + "', carrera='" + alumno.getCarrera() + 
				"', semestre='" + alumno.getSemestre() + "' where controlnumber='" + alumno.getControlNumber() + "'";
		try {
			int n = statement.executeUpdate(sql);
			if (n == 1) {
				return "Exito";
			} else {
				return "Error";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
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