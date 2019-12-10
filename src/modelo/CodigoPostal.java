package modelo;

public class CodigoPostal {
	private String codigoPostal;
	private String colonia;
	private String ciudad;
	private String estado;
	
	public CodigoPostal(String codigoPostal, String estado , String ciudad, String colonia) {
		super();
		this.codigoPostal = codigoPostal;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.estado = estado;
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
}