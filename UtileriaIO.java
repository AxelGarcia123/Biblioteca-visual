package utileria;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import modelo.Alumno;
import modelo.Domicilio;
import modelo.Libro;
public class UtileriaIO {

	public static File getArchivo() {
		JFileChooser selector=new JFileChooser("C:\\TOPICOS");
		int respuesta=selector.showOpenDialog(null);
		if (selector.APPROVE_OPTION == respuesta) {
			File archivo=selector.getSelectedFile();
			return archivo;
		} else return null;

	}

	public static List<String> getDatos(File archivo){
		try {
			Scanner entrada=new Scanner(archivo);
			List<String> cadenas=new ArrayList<String>();
			while (entrada.hasNext()) {
				String cadena=entrada.nextLine();
				cadenas.add(cadena);
			}
			return cadenas;
		} catch (FileNotFoundException e) {
			return null;

		}
	}
	public static List<Alumno> leerAlumnosIO(List<String> datos){
		List<Alumno> alumnos=new ArrayList<Alumno>();
		for (int i =0; i < datos.size(); i++) {
			String cadena = datos.get(i);
			String[] arrayPalabras = cadena.split(",");
			String clave = arrayPalabras[0];  
			String  nombre= arrayPalabras[1];
			String paterno= arrayPalabras[2];
			String materno= arrayPalabras[3];
			Date fechaNacimiento;
			String fecha= arrayPalabras[4];
			fechaNacimiento= new Date(fecha);
			String edad= arrayPalabras[5];
			String genero= arrayPalabras[6];
			String telefono =arrayPalabras[7];
			String eMail= arrayPalabras[8];
			String numCasa = arrayPalabras[9];
			String calle= arrayPalabras[10];
			String cp = arrayPalabras[11];
			String colonia = arrayPalabras[12];
			String ciudad= arrayPalabras[13];
			String estado= arrayPalabras[13];
			Domicilio domicilio= new Domicilio(numCasa, calle, cp, colonia, ciudad, estado);
			Alumno alumno= new Alumno(clave, nombre, paterno, materno, fechaNacimiento, edad, genero, telefono, eMail, domicilio);
			alumnos.add(alumno);
		}
		return alumnos;
	}	
	public static List<Libro> leerLibrosIO(List<String> datos){
		List<Libro> libros=new ArrayList<Libro>();
		for (int i =0; i < datos.size(); i++) {
			String cadena = datos.get(i);
			String[] arrayPalabras = cadena.split(",");
			String isbn= arrayPalabras[0];
			String  titulo= arrayPalabras[1];
			String autor= arrayPalabras[2];
			String editorial= arrayPalabras[3];
			String numedicion= arrayPalabras[4];
			String añoEdicion= arrayPalabras[5];
			String idioma= arrayPalabras[6];
			String paisOrigen= arrayPalabras[7];
			Libro libro= new Libro(isbn, titulo, autor, editorial, numedicion, añoEdicion, idioma, paisOrigen);
			libros.add(libro);
		}
		return libros;
	}
}