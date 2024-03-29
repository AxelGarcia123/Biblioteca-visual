package modelo;

public class Domicilio {
	private String numeroCasa;
	private String calle;
	private String colonia;
	private String codigoPostal;
	private String ciudad;
	private String estado;
	
	public Domicilio() {
		super();
	}

	public Domicilio(String numeroCasa, String calle, String colonia, String codigoPostal, String ciudad, String estado) {
		super();
		this.numeroCasa = numeroCasa;
		this.calle = calle;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.estado = estado;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		String salida = "";
		salida += "N\u00famero de casa:" + numeroCasa + "\n";
		salida += "Calle:" + calle + "\n";
		salida += "Colonia:" + colonia + "\n";
		salida += "C\u00f3digo Postal:" + codigoPostal + "\n";
		salida += "Ciudad:" + ciudad + "\n";
		salida += "Estado:" + estado;
		return salida;
	}
}