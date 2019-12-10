package codigospostales;

import java.util.ArrayList;
import java.util.List;
public class CodigosPostales {
	private List<CodigoPostal> codigos;
	
	public CodigosPostales() {
		codigos=new ArrayList<>();
		
	}
	
	public boolean existe(String codigo) {
		return codigos.contains(new CodigoPostal(codigo));
		
	}
	
	public void registrar(CodigoPostal codigoPostal) {
		codigos.add(codigoPostal);
	}
	
	public CodigoPostal getElemento(CodigoPostal codigoPostal) {
		int posicion=codigos.indexOf(codigoPostal);
		return codigos.get(posicion);
	}

	@Override
	public String toString() {
		return "CodigosPostales [codigos=" + codigos.toString() + "]";
	}
	
	public List<String> getCodigosPostales(){
		List<String> lista=new ArrayList<>();
		for (CodigoPostal codigoPostal : codigos) {
			lista.add(codigoPostal.getCodigo());
		}
		return lista;	
	}
	
	public List<String> getColonias(String codigo){
		List<String> listaColonias=new ArrayList<>();
		CodigoPostal cp=codigos.get(codigos.indexOf(new CodigoPostal(codigo)));
		
		return cp.getColonia();
		
	}
}