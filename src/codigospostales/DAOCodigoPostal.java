package codigospostales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DAOCodigoPostal {


	public static CodigosPostales getCodigos(String ruta){
		CodigosPostales codigosPostales=new CodigosPostales();
		File archivo=new File(ruta);
		if (archivo.exists()) {
			try {
				Scanner entrada=new Scanner(archivo);
				List<String> lineas=new ArrayList<>();
				while(entrada.hasNext()) {
					String cadena=entrada.nextLine();
					lineas.add(cadena);
				}

				for (String cadena : lineas) {
					EstructuraCodigo estructuraCodigo= generarCodigoPostal(cadena);
					if (!codigosPostales.existe(estructuraCodigo.getCodigo())) {
						CodigoPostal codigoPostal=new CodigoPostal();
						codigoPostal.setCodigo(estructuraCodigo.getCodigo());
						codigoPostal.agregarColonia(estructuraCodigo.getColonia());
						codigoPostal.agregarCiudad(estructuraCodigo.getCiudad());
						codigoPostal.agregarEstado(estructuraCodigo.getEstado());
						codigosPostales.registrar(codigoPostal);

					} else {
						CodigoPostal codigoPostal=codigosPostales.getElemento(new CodigoPostal(estructuraCodigo.getCodigo()));
						codigoPostal.agregarColonia(estructuraCodigo.getColonia());
						codigoPostal.agregarCiudad(estructuraCodigo.getCiudad());
						codigoPostal.agregarEstado(estructuraCodigo.getEstado());

					}	
				}
				return codigosPostales;

			} catch (FileNotFoundException e) {
				// TODO: handle exception
				return null;
			}

		} else {
			System.out.println("archivo no existe");
			return null;

		}	
	}

	public static  EstructuraCodigo generarCodigoPostal(String cadena) {
		StringTokenizer st=new StringTokenizer(cadena,"\t");
		List<String> cadenas=new ArrayList<>();
		while(st.hasMoreElements()) {
			cadenas.add(st.nextToken());
		}
		EstructuraCodigo estructuraCodigo=new EstructuraCodigo(cadenas.get(0), cadenas.get(1), cadenas.get(2), cadenas.get(3));
		return estructuraCodigo;

	}
}
